package com.liukai.concurrent.threadpool.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 测试 callable
 * Created by liu kai on 2017/1/13.
 */
public class TestCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 50; i++) {
            Future<String> future = executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "...开始执行....");
                for (int i1 = 0; i1 < 500; i1++) {
                    System.out.println(Thread.currentThread().getName() + "----" + i1);
                    if (i1 == 300) {
                        System.out.println(Thread.currentThread().getName() + "处理特殊业务");
                    }
                }
                return Thread.currentThread().getName();
            });

            futures.add(future);
        }

        //并闭线程池
        executorService.shutdown();

        for (Future<String> future : futures) {
            System.out.println("打印任务执行结果: " + future.get());
        }
        System.out.println(Thread.currentThread().getName());
    }
}
