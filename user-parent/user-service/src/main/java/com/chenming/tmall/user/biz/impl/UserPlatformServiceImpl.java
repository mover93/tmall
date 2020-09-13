package com.chenming.tmall.user.biz.impl;

import com.chenming.tmall.common.dto.UserPlatformDto;
import com.chenming.tmall.common.result.CommonResult;
import com.chenming.tmall.user.biz.UserPlatformService;
import com.chenming.tmall.user.service.PlatformService;
import com.chenming.tmall.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import sun.java2d.SurfaceDataProxy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * description: UserPlatformServiceImpl <br>
 * author: chenming <br>
 * date: 2020/9/13 15:51 <br>
 * version: 1.0 <br>
 */
@Service
@Slf4j
public class UserPlatformServiceImpl implements UserPlatformService {

    @Autowired
    private UserService userService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public CommonResult process(UserPlatformDto userPlatformDto) {

        AtomicBoolean flag = new AtomicBoolean(false);
        CountDownLatch cdl = new CountDownLatch(1);
        CountDownLatch cdlEnd = new CountDownLatch(2);

        // 1、新增用户
        executorService.execute(() -> {
            DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
            defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            TransactionStatus transactionStatus = platformTransactionManager.getTransaction(defaultTransactionDefinition);

            try {
                userService.addUser(userPlatformDto.getUserDto());
            } catch(Exception ex) {
                flag.set(true);
            } finally {
                cdlEnd.countDown();
            }

            try {
                cdl.await();
            } catch (InterruptedException e) {
                flag.set(true);
            }

            if (flag.get()) {
                platformTransactionManager.rollback(transactionStatus);
            } else {
                platformTransactionManager.commit(transactionStatus);
            }
        });

        // 2、新增平台
        executorService.execute(() -> {
            DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
            defaultTransactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
            TransactionStatus transactionStatus = platformTransactionManager.getTransaction(defaultTransactionDefinition);

            try {
                platformService.addPlatform(userPlatformDto.getPlatformDto());

                int i = 1 / 0;
            } catch(Exception ex) {
                flag.set(true);
            } finally {
                cdlEnd.countDown();
            }

            try {
                cdl.await();
            } catch (InterruptedException e) {
                flag.set(true);
            }

            if (flag.get()) {
                platformTransactionManager.rollback(transactionStatus);
            } else {
                platformTransactionManager.commit(transactionStatus);
            }
        });

        try {
            cdlEnd.await();
        } catch (InterruptedException e) {

        } finally {
            cdl.countDown();
        }

        return CommonResult.success();
    }
}
