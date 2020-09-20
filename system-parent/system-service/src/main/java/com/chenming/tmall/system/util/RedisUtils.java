package com.chenming.tmall.system.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * description: RedisUtils <br>
 * author: chenming <br>
 * date: 2020/9/16 20:27 <br>
 * version: 1.0 <br>
 */
@Component
@Slf4j
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public boolean put(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch(Exception ex) {
            log.error("RedisUtils.put(key={}, value={}) exception={}", key, value, ex.getMessage());
            return false;
        }
    }

    public boolean put(String key, String value, long expire) {
        try {
            redisTemplate.opsForValue().set(key, value, expire, TimeUnit.MILLISECONDS);
            return true;
        } catch(Exception ex) {
            log.error("RedisUtils.put(key={}, value={}) exception={}", key, value, ex.getMessage());
            return false;
        }
    }

    public String get(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch(Exception ex) {
            log.error("RedisUtils.get(key={}) exception={}");
            return null;
        }
    }

    public boolean expire(String key, long timeout) {
        try {
            return redisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
        } catch(Exception ex) {
            log.error("RedisUtils.expire(key={}, timeout={}) exception={}", key, timeout, ex.getMessage());
            return false;
        }
    }

    public boolean batchPut(Map<String, String> data) {
        try {
            redisTemplate.opsForValue().multiSet(data);
            return true;
        } catch(Exception ex) {
            log.error("RedisUtils.batchPut(data={}) exception={}", JSON.toJSONString(data), ex.getMessage());
            return false;
        }
    }

    public List<String> batchGet(Set<String> keys) {
        try {
            return redisTemplate.opsForValue().multiGet(keys);
        } catch(Exception ex) {
            log.error("RedisUtils.batchGet(keys={}) exception={}", JSON.toJSONString(keys), ex.getMessage());
            return null;
        }
    }
}
