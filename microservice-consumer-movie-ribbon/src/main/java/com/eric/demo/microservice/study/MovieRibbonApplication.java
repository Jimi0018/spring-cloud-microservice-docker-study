package com.eric.demo.microservice.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieRibbonApplication.class, args);
    }
}