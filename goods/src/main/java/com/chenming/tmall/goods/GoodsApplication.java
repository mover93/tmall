package com.chenming.tmall.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * description: GoodsApplication <br>
 * author: chenming <br>
 * date: 2020/9/8 23:37 <br>
 * version: 1.0 <br>
 */
@SpringBootApplication
@MapperScan(value = "com.chenming.tmall.goods.mapper")
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
