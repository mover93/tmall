package com.chenming.tmall.common.async;

import java.util.concurrent.ExecutionException;

/**
 * description: AsyncResult <br>
 * author: chenming <br>
 * date: 2020/9/13 21:43 <br>
 * version: 1.0 <br>
 */
public interface AsyncResult<T> {

    /**
     * 异步任务是否完成
     * @return
     */
    boolean isCompleted();

    /**
     * 获取异步任务的返回值
     * @return
     * @throws ExecutionException
     */
    T getValue() throws ExecutionException;

    /**
     * 阻塞当前线程知道异步任务已完成
     * @throws InterruptedException
     */
    void await() throws InterruptedException;
}
