package com.chenming.tmall.user;

import com.chenming.tmall.user.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

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

    @Autowired
    private RedissonClient redissonClient;

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

    @Test
    public void testLock() {
        // 1、通用用法
//        RLock lock = redissonClient.getLock("anyLock");
//        lock.lock();
//
//        try {
//            Thread.sleep(50000);
//        } catch (InterruptedException e) {
//            // ignore
//        } finally {
//            lock.unlock();
//        }

        // 2、尝试加锁

        // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
        RLock lock = redissonClient.getLock("anyLock");

        try {
            boolean flag = lock.tryLock(100, 30, TimeUnit.SECONDS);

            if (flag) {
                //
                Thread.sleep(10000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            if (lock != null && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }


    }
}
