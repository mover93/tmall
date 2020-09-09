package com.chenming.tmall.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description: RegistryApplication <br>
 * author: chenming <br>
 * date: 2020/9/9 11:13 <br>
 * version: 1.0 <br>
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class, args);
    }
}
