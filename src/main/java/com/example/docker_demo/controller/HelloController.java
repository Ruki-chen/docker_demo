package com.example.docker_demo.controller;

import com.example.docker_demo.entity.HelloEntity;
import com.example.docker_demo.fo.HelloFo;
import com.example.docker_demo.service.HelloService;
import com.example.docker_demo.vo.HelloVo;
import com.sun.org.apache.xpath.internal.operations.Bool;
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

    @PostMapping
    @ApiOperation(value = "增加说hello", notes = "增加说hello")
    public HelloVo addHello(@Valid @RequestBody final HelloFo helloFo){
        HelloEntity save = helloService.save(helloFo.toHelloEntity());
        return new HelloVo(save);
    }

    @PutMapping
    @ApiOperation(value = "修改说hello", notes = "修改说hello")
    public HelloVo updateHello(@Valid @RequestBody final HelloFo helloFo){
        HelloEntity save = helloService.updateHello(helloFo);
        return new HelloVo(save);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "返回hello", notes = "返回hello")
    public HelloVo sayILoveYou(@PathVariable final Long id){
        HelloEntity one = helloService.findOne(id);
        return new HelloVo(one);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "返回hello", notes = "返回hello")
    public Boolean delete(@PathVariable final Long id){
        helloService.delete(id);
        return true;
    }
}
