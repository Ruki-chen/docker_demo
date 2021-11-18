package com.example.docker_demo.controller;

import com.example.docker_demo.entity.HelloEntity;
import com.example.docker_demo.service.HelloService;
import com.example.docker_demo.vo.HelloVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/hello")
@Api(value = "hello", tags = "hello测试")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @PostMapping("addHello")
    @ApiOperation(value = "增加说hello", notes = "增加说hello")
    public HelloVo addHello(@Valid @RequestBody final HelloVo helloVo){   //一定要有无参的构造函数
        HelloEntity save = helloService.save(helloVo.toHelloEntity());
        return new HelloVo(save);
    }

    @GetMapping("getHello/{id}")
    @ApiOperation(value = "返回hello", notes = "返回hello")
    public HelloVo sayILoveYou(@PathVariable final Long id){
        HelloEntity one = helloService.findOne(id);
        return new HelloVo(one);
    }
}
