package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zyd
 * @date 2019/03/29
 */
@SpringBootApplication(
        scanBasePackages = {
                "com.example.jpa"
        }
)
public class JpaApp {

    public static void main(String[] args) {
        SpringApplication.run(JpaApp.class, args);
    }

}
