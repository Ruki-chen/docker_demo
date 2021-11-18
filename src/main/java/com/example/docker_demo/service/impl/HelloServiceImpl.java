package com.example.docker_demo.service.impl;

import com.example.docker_demo.entity.HelloEntity;
import com.example.docker_demo.repository.BaseRepository;
import com.example.docker_demo.repository.HelloRepository;
import com.example.docker_demo.service.HelloService;
import com.example.docker_demo.vo.HelloVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yfa
 */
@Service
public class HelloServiceImpl extends BaseServiceImpl<HelloEntity, HelloVo, Long> implements  HelloService {

    @Autowired
    private HelloRepository helloRepository;
    @Override
    protected BaseRepository<HelloEntity, Long> currentJpaRepository() {
        return helloRepository;
    }
}
