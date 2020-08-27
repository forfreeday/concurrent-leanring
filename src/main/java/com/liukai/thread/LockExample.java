package com.liukai.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author liukai
 * @since 2020/7/4 21:22.
 */
public class LockExample {

    public static void main(String[] args) {

    }

    public static void deadLock() {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("获取 lock1 成功");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 试图获取锁 lock2
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });

        new Thread(() -> {
            synchronized (lock1) {


            }
        });
    }
}
