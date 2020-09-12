package com.chenming.tmall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: UserServiceApplication <br>
 * author: chenming <br>
 * date: 2020/9/10 22:15 <br>
 * version: 1.0 <br>
 */
@EnableFeignClients
@SpringBootApplication
@MapperScan(value = "com.chenming.tmall.user.mapper")
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
