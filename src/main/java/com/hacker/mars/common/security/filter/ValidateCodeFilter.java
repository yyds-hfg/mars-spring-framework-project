package com.hacker.mars.common.security.filter;

import com.hacker.mars.common.exception.ValidateCodeException;
import com.hacker.mars.common.security.MarsAuthenticationHandler;
import com.hacker.mars.common.security.ValidateCodeCache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 验证码过滤器
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-14
 */
@Component
@RequiredArgsConstructor
public class ValidateCodeFilter extends OncePerRequestFilter {

    /**
     * 授权处理器
     */
    private final MarsAuthenticationHandler authenticationSuccessHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().equals("/login") && request.getMethod().equals("POST")) {
            try {
                this.validate(request);
            } catch (ValidateCodeException e) {
                authenticationSuccessHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        //如果不是登录请求，直接调用后面的过滤器链
        filterChain.doFilter(request, response);
    }

    private void validate(HttpServletRequest request) {
        //获取ip
        String remoteAddr = request.getRemoteAddr();
        //拼接缓存的key
        String redisKey = ValidateCodeCache.IMAGE_CODE_KEY + remoteAddr;
        //从本地缓存中获取imageCode
        String imageCodeCache = ValidateCodeCache.get(redisKey);
        String imageCode = request.getParameter("imageCode");
        if (!StringUtils.hasText(imageCode)) {
            throw new ValidateCodeException("验证码的值不能为空！");
        }
        if (imageCodeCache == null) {
            throw new ValidateCodeException("验证码已过期！");
        }
        if (!imageCodeCache.equals(imageCode)) {
            throw new ValidateCodeException("验证码不正确！");
        }
        // 从redis中删除imageCode
        ValidateCodeCache.remove(redisKey);
    }

}
