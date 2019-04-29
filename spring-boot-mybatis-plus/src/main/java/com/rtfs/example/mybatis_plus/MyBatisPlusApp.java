package com.rtfs.example.mybatis_plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rtfs.example.mybatis_plus.dao")
public class MyBatisPlusApp {
    public static void main(String[] args) {
        SpringApplication.run(MyBatisPlusApp.class, args);
    }
}
