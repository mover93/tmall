package com.chenming.tmall.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * description: ZuulServiceApplication <br>
 * author: chenming <br>
 * date: 2020/9/13 0:45 <br>
 * version: 1.0 <br>
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServiceApplication.class, args);
    }
}
