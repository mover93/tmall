package com.chenming.tmall.user.thread;

import com.chenming.tmall.common.async.AsyncCallback;
import com.chenming.tmall.common.async.AsyncExecutor;
import com.chenming.tmall.common.async.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description: ThreadAsyncExecutor <br>
 * author: chenming <br>
 * date: 2020/9/13 21:53 <br>
 * version: 1.0 <br>
 */
@Component
public class ThreadAsyncExecutor implements AsyncExecutor {

    @Autowired
    private ExecutorService executorService;

    private final AtomicInteger idx = new AtomicInteger(0);

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task) {
        return startProcess(task, null);
    }

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback) {
        CompletableResult<T> result = new CompletableResult<>(callback);
        executorService.execute(() -> {
            try {
                result.setValue(task.call());
            } catch (Exception ex) {
                result.setException(ex);
            }
        });
        return result;
    }

    @Override
    public <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException {
        if (!asyncResult.isCompleted()) {
            asyncResult.await();
        }
        return asyncResult.getValue();
    }

    private static class CompletableResult<T> implements AsyncResult<T> {

        static final int RUNNING = 1;
        static final int FAILED = 2;
        static final int COMPLETED = 3;

        final Object lock;
        final AsyncCallback<T> callback;
        volatile int state = RUNNING;
        T value;
        Exception exception;

        CompletableResult(AsyncCallback<T> callback) {
            this.lock = new Object();
            this.callback = callback;
        }

        void setValue(T value) {
            this.value = value;
            this.state = COMPLETED;
            if (callback != null) {
                callback.onComplete(value, null);
            }
            synchronized (lock) {
                lock.notifyAll();
            }
        }

        /**
         * Sets the exception from failed execution and executes callback if available. Notifies any
         * thread waiting for completion.
         *
         * @param exception exception of the failed task
         */
        void setException(Exception exception) {
            this.exception = exception;
            this.state = FAILED;
            if (callback != null) {
                callback.onComplete(null, exception);
            }
            synchronized (lock) {
                lock.notifyAll();
            }
        }

        @Override
        public boolean isCompleted() {
            return state > RUNNING;
        }

        @Override
        public T getValue() throws ExecutionException {
            if (state == COMPLETED) {
                return value;
            } else if (state == FAILED) {
                throw new ExecutionException(exception);
            } else {
                throw new IllegalStateException("Execution not completed yet");
            }
        }

        @Override
        public void await() throws InterruptedException {
            synchronized (lock) {
                while (!isCompleted()) {
                    lock.wait();
                }
            }
        }
    }
}
