package com.chenming.tmall.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * description: EurekaServiceApplication <br>
 * author: chenming <br>
 * date: 2020/9/13 0:32 <br>
 * version: 1.0 <br>
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }
}
