package com.eric.demo.microservice.study.service.impl;

import com.eric.demo.microservice.study.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public boolean test(){
        return true;
    }

    @Override
    public String findByName(){
        return "test";
    }

    @Override
    public String findByTitle(){
        return "eric测试1";
    }
}
