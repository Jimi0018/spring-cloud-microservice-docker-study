package com.eric.demo.microservice.study.action;

import com.eric.demo.microservice.study.entity.User;
import com.eric.demo.microservice.study.rpc.RibbonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RibbonController {
    @Resource
    private RibbonService ribbonService;

    @GetMapping("/ribbon/{id}")
    public User findById(@PathVariable Long id) {
        return this.ribbonService.findById(id);
    }
}