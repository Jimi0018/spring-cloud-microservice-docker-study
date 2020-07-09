package com.eric.demo.microservice.study.service.impl;

import com.eric.demo.microservice.study.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String test(){
        return "test";
    }
}
