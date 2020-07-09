package com.eric.demo.microservice.study.rpc;

import com.eric.demo.microservice.study.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用@FeignClient("provider-user")注解绑定provider-user服务，还可以使用url参数指定一个URL。 使用@FeignClient注解的fallback属性，指定fallback类
 */
@FeignClient(name = "provider-user")
public interface UserFeignClient {
    @RequestMapping("/user/{id}")
    User findByIdFeign(@PathVariable(value = "id") Long id);
}