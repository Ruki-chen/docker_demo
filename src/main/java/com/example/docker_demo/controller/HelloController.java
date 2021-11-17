package com.example.docker_demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Api(value = "hello", tags = "hello测试")
public class HelloController {

    @GetMapping("/sayHello")
    @ApiOperation(value = "返回用户名", notes = "返回用户名")
    public String say(@RequestParam String userName){
        return "hello,"+userName+"!";
    }
}
