package com.eric.demo.microservice.study.action;

import com.eric.demo.microservice.study.entity.User;
import com.eric.demo.microservice.study.rpc.UserFeignHystrixClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {
    @Resource
    private UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("feign/{id}")
    public User findByIdFeign(@PathVariable Long id) {
        User user = this.userFeignHystrixClient.findByIdFeign(id);
        return user;
    }
}