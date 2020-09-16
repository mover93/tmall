package com.chenming.tmall.user;

import com.chenming.tmall.user.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * description: RedisUtilsTests <br>
 * author: chenming <br>
 * date: 2020/9/16 20:58 <br>
 * version: 1.0 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilsTests {

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void testPut() {
        boolean flag = redisUtils.put("user:id:1", "chenming");
    }

    @Test
    public void testExpire() {
        boolean flag = redisUtils.expire("user:id:1", 30000);
    }

    @Test
    public void testGet() {
        String value = redisUtils.get("user:id:1");
        System.out.println(value);
    }
}
