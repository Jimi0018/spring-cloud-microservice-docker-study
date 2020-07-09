package com.eric.demo.microservice.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 使用@EnableCircuitBreaker注解开启断路器功能
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
public class MovieRibbonHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieRibbonHystrixApplication.class, args);
    }
}