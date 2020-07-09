package com.eric.demo.microservice.study.rpc;

import com.eric.demo.microservice.study.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class RibbonService {
    @Resource
    private RestTemplate restTemplate;

    public User findById(Long id) {
        // http://服务提供者的serviceId/url
        return this.restTemplate.getForObject("http://provider-user/user/" + id, User.class);
    }
}