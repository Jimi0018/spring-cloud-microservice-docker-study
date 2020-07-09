package com.eric.demo.microservice.study.rpc;

import com.eric.demo.microservice.study.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Slf4j
public class RibbonHystrixService {
    @Resource
    private RestTemplate restTemplate;

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     *
     * @param id id
     *
     * @return 通过id查询到的用户
     */
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"))
    public User findById(Long id) {
        // http://服务提供者的serviceId/url
        return this.restTemplate.getForObject("http://provider-user/user/" + id, User.class);
    }

    /**
     * hystrix fallback方法
     *
     * @param id id
     *
     * @return 默认的用户
     */
    public User fallback(Long id) {
        log.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
        User user = new User();
        user.setId(-1L);
        user.setUsername("default username");
        user.setAge(0);
        return user;
    }
}