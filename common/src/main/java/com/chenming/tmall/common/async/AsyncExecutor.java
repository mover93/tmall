package com.chenming.tmall.common.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * description: AsyncExecutor <br>
 * author: chenming <br>
 * date: 2020/9/13 21:50 <br>
 * version: 1.0 <br>
 */
public interface AsyncExecutor {

    /**
     * 开启一个异步任务
     * @param task
     * @param <T>
     * @return
     */
    <T> AsyncResult<T> startProcess(Callable<T> task);

    /**
     * 开启一个异步任务
     * @param task
     * @param callback
     * @param <T>
     * @return
     */
    <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback);

    /**
     * 结束一个异步任务
     * @param asyncResult
     * @param <T>
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException;
}
