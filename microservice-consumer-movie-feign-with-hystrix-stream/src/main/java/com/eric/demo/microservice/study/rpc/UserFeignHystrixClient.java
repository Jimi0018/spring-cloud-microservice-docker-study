package com.eric.demo.microservice.study.rpc;

import com.eric.demo.microservice.study.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用@FeignClient("provider-user")注解绑定provider-user服务，还可以使用url参数指定一个URL。 使用@FeignClient注解的fallback属性，指定fallback类
 */
@FeignClient(name = "provider-user", fallback = UserFeignHystrixClient.HystrixClientFallback.class)
public interface UserFeignHystrixClient {
    @RequestMapping("/user/{id}")
    User findByIdFeign(@PathVariable(value = "id") Long id);

    /**
     * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
     */
    @Component
    @Slf4j
    class HystrixClientFallback implements UserFeignHystrixClient {
        /**
         * hystrix fallback方法
         *
         * @param id id
         *
         * @return 默认的用户
         */
        @Override
        public User findByIdFeign(Long id) {
            log.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
            User user = new User();
            user.setId(-1L);
            user.setUsername("默认用户");
            user.setAge(0);
            return user;
        }
    }
}