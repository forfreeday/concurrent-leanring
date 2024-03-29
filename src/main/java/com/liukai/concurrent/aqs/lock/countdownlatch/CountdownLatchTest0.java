package com.liukai.concurrent.aqs.lock.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 主线程等待子线程执行完成再执行
 */
public class CountdownLatchTest0 {
    static final CountDownLatch latch = new CountDownLatch(3);
    private static final ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.countDown();//当前线程调用此方法，则计数减一
                        System.out.println("子线程" + Thread.currentThread().getName() + "开始执行");
                        Thread.sleep(100);
                        System.out.println("子线程"+Thread.currentThread().getName()+"执行完成");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(runnable);
        }

        try {
            System.out.println("主线程"+Thread.currentThread().getName()+"等待子线程执行完成...");
            latch.await();//阻塞当前线程，直到计数器的值为0
            System.out.println("主线程"+Thread.currentThread().getName()+"执行执行完成...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}