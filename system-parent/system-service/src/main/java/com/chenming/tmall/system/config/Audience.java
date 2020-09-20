package com.chenming.tmall.system.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * description: Audience <br>
 * author: chenming <br>
 * date: 2020/9/20 18:22 <br>
 * version: 1.0 <br>
 */
@Data
@Component
public class Audience {

    //代表这个JWT的接收对象,存入audience
    @Value("${audience.aud}")
    private String aud;

    @Value("${audience.base64Secret}")
    private String base64Secret;

    //JWT的签发主体，存入issuer
    @Value("${audience.iss}")
    private String iss;

    @Value("${audience.expiresSecond}")
    private int expiresSecond;

}
