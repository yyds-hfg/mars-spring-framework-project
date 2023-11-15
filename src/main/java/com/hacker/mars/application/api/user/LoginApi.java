package com.hacker.mars.application.api.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-12
 */
@Api(value = "用户操作")
@Controller
public class LoginApi {
    
    @RequestMapping("/toLoginPage")
    @ApiOperation(value = "登录接口",notes = "页面登录用")
    public String toLoginPage() {
        return "login";
    }

    @RequestMapping("/")
    @ApiOperation(value = "登录成功之后跳转使用",notes = "页面登录使用")
    public String index() {
        return "index";
    }

}
