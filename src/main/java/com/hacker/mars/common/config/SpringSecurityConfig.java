package com.hacker.mars.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <p>
 * SpringSecurity配置类
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-12
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) {
        //忽略静态资源被拦截的问题
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //开启HttpBasic认证, 所有的请求都需要认证才可以访问
        //http.httpBasic().and().authorizeRequests().anyRequest().authenticated();
        //这种把用户名,密码通过md5加密然后进行传输,生成不建议使用

        http.formLogin() //开启表单验证
                .loginPage("/toLoginPage")  //LoginController的方法 自定义登录页面
                .loginProcessingUrl("/login") //表单提交的路径
                .usernameParameter("username")
                .passwordParameter("password") //待提交密码的input值
                .successForwardUrl("/")  //登录成功之后跳转的路径
                .and().authorizeRequests().antMatchers("/toLoginPage").permitAll().anyRequest().authenticated();

        //关闭csrf防护
        http.csrf().disable();

        // 加载同源域名下的iframe页面,允许iframe加载页面
        http.headers().frameOptions().sameOrigin();
    }

}

