package com.chenming.tmall.user.config.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * user-service模块业务线程池 <br>
 * author: chenming <br>
 * date: 2020/9/13 10:57 <br>
 * version: 1.0 <br>
 */
@Configuration
@Slf4j
public class ExecutorConfig {

    @Value("${threadpool.corePoolSize:10}")
    private int corePoolSize;

    @Value("${threadpool.maximumPoolSize:30}")
    private int maximumPoolSize;

    @Value("${threadpool.keepAliveTime:3000}")
    private long keepAliveTime;

    @Value("${threadpool.workQueueSize:10000}")
    private int workQueueSize;

    @Bean
    public ExecutorService executorService() {

        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(workQueueSize);

        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();

        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                blockingQueue,
                new ThreadFactoryImpl("user-service-threadpool-"),
                handler);

        log.info("user-service-threadpool inited");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (!executorService.isShutdown()) {
                log.info("user-service-threadpool is shutdowned");
                executorService.shutdown();
            }
        }));

        return executorService;
    }

    private static class ThreadFactoryImpl implements ThreadFactory {

        private AtomicLong num = new AtomicLong(0);

        private String prefix;

        public ThreadFactoryImpl(String prefix) {
            this.prefix = prefix;
        }

        @Override
        public Thread newThread(Runnable r) {
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            sb.append(num.getAndIncrement());
            Thread thread = new Thread(r, sb.toString());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            return thread;
        }
    }
}
