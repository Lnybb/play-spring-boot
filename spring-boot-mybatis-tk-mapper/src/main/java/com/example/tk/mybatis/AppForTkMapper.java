package com.example.tk.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = {"com.example.tk.mybatis"})
public class AppForTkMapper {

    public static void main(String[] args) {
        SpringApplication.run(AppForTkMapper.class, args);
    }

}

