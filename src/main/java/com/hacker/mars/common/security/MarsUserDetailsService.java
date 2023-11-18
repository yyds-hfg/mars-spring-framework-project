package com.hacker.mars.common.security;

import com.hacker.mars.domain.user.UserService;
import com.hacker.mars.infrastructure.persistent.po.TUserPo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * 用户数据接口
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-13
 */
@Slf4j
@Component
@AllArgsConstructor
public class MarsUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TUserPo userPo = userService.findByUsername(username);
        if (userPo == null) {
            throw new UsernameNotFoundException("用户没有找到.");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equalsIgnoreCase(username)) {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_PRODUCT"));
        }
        //"{noop}" 不使用密码加密
        //框架会把前端传过来的密码与当前的密码进行比对
        //用户是否启用,用户是否过期,用户凭证是否过期,用户是否锁定
        return new User(userPo.getUsername(), "{bcrypt}" + userPo.getPassword(),
                true,
                true,
                true,
                true,
                authorities);
    }

}
