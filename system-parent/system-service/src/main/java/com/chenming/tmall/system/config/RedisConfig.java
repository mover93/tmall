package com.chenming.tmall.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * description: RedisConfig <br>
 * author: chenming <br>
 * date: 2020/9/16 20:30 <br>
 * version: 1.0 <br>
 */
@Configuration
public class RedisConfig {

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {

        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("127.0.0.1", 6379);
        return new JedisConnectionFactory(config);
    }

}
