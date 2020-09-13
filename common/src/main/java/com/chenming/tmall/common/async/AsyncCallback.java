package com.chenming.tmall.common.async;

/**
 * description: AsyncCallback <br>
 * author: chenming <br>
 * date: 2020/9/13 21:47 <br>
 * version: 1.0 <br>
 */
public interface AsyncCallback<T> {

    /**
     * 回调方法，当异步任务已完成或执行过程出现异常的时候执行
     * @param value
     * @param ex
     */
    void onComplete(T value, Exception ex);
}
