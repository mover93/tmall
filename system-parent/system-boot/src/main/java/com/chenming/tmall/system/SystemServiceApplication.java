package com.chenming.tmall.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description: SystemServiceApplication <br>
 * author: chenming <br>
 * date: 2020/9/12 9:51 <br>
 * version: 1.0 <br>
 */
@EnableFeignClients
@MapperScan(value = "com.chenming.tmall.system.mapper")
@SpringBootApplication
public class SystemServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemServiceApplication.class, args);
    }
}
