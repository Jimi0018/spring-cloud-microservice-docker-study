package com.eric.demo.microservice.study.action;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.eric.demo.microservice.study.dao.UserRepository;
import com.eric.demo.microservice.study.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 作用：
 * ① 测试服务实例的相关内容
 * ② 为后来的服务做提供
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
  @Resource
  private DiscoveryClient discoveryClient;
  @Resource
  private UserRepository userRepository;
  @Resource
  private RestTemplate restTemplate;
  @Value("${spring.application.name}")
  private String serviceId;

  /**
   * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
   * @RequestMapping(value = "/id", method = RequestMethod.GET)
   * 类似的注解还有@PostMapping等等
   * @param id
   * @return user信息
   */
  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    Optional<User> record = userRepository.findById(id);
    return record.get();
  }

  /**
   * 本地服务实例的信息
   */
  @GetMapping("/instanceInfo")
  public ServiceInstance showInfo() {
    //获取实例列表
    List<ServiceInstance> instancesList = discoveryClient.getInstances(serviceId);
    //获取实例
    ServiceInstance instance = instancesList.get(0);
    log.info("请求结果:{}", JSON.toJSONString(instance, new SimplePropertyPreFilter("instanceId")));
    return instance;
  }
}