package com.example.docker_demo.service;


import com.example.docker_demo.entity.HelloEntity;
import com.example.docker_demo.fo.HelloFo;
import com.example.docker_demo.vo.HelloVo;

/**
 * @Author cwr
 */
public interface HelloService extends BaseService<HelloEntity, HelloVo, Long> {

    HelloEntity updateHello(HelloFo helloFo);
}
