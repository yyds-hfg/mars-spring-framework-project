package com.hacker.mars.common.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 自定义Bean授权
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-18
 */
@Component
public class MarsAuthorizationService {

    /**
     * 检查用户是否有权限
     *
     * @param authentication 认证信息
     * @param request        请求对象
     * @return boolean
     */
    public boolean check(Authentication authentication, HttpServletRequest request) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        if ("admin".equalsIgnoreCase(username)) {
            return true;
        }
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/user")) {
            return hasMatchRole(authentication, "ROLE_ADMIN");
        }
        if (requestURI.contains("/product")) {
            return hasMatchRole(authentication, "ROLE_PRODUCT");
        }
        return false;
    }

    /**
     * 判断当前用户是否权限
     *
     * @param authentication 认证信息
     * @param role           角色
     * @return boolean
     */
    private static boolean hasMatchRole(Authentication authentication, String role) {
        return authentication.getAuthorities().stream().anyMatch(grantedAuthority -> role.equalsIgnoreCase(grantedAuthority.getAuthority()));
    }

}
