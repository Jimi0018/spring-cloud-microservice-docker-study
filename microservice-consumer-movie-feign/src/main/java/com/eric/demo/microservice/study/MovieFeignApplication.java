package com.eric.demo.microservice.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 使用@EnableFeignClients开启Feign
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MovieFeignApplication {
  public static void main(String[] args) {
    SpringApplication.run(MovieFeignApplication.class, args);
  }
}