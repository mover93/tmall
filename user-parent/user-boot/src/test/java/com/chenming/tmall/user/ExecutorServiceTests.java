package com.chenming.tmall.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * description: ExecutorServiceTests <br>
 * author: chenming <br>
 * date: 2020/9/13 11:29 <br>
 * version: 1.0 <br>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExecutorServiceTests {

    @Autowired
    private ExecutorService executorService;

    @Test
    public void testExecutorService() {
        List<CompletableFuture<?>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
          CompletableFuture<?> future = CompletableFuture.supplyAsync(() -> {
              Random random = new Random();
              long sleepTime = random.nextInt(10000);

              try {
                  Thread.sleep(sleepTime);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println(Thread.currentThread().getName() + "==" + sleepTime);
              return null;
            }, executorService);
            futures.add(future);
        }

        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        all.join();
    }
}
