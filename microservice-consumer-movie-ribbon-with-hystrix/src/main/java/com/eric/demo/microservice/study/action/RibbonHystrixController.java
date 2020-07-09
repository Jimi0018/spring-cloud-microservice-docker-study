package com.eric.demo.microservice.study.action;

import com.eric.demo.microservice.study.entity.User;
import com.eric.demo.microservice.study.rpc.RibbonHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RibbonHystrixController  {
    @Resource
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/ribbon/{id}")
    public User findById(@PathVariable Long id) {
        return this.ribbonHystrixService.findById(id);
    }
}