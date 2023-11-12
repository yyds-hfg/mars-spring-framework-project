package com.hacker.mars.application.api.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-10-14
 */
@RestController
@RequestMapping("/echo")
@Api(value = "echo测试")
public class EchoApi {

    @ApiOperation(value = "echo测试")
    @GetMapping("/echo")
    public String echo() {
        return "echo";
    }

}
