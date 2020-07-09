package com.eric.demo.microservice.study.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private Long id;
    private String username;
    private Integer age;

}