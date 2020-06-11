package com.liukai.concurrent.thread.synchronizeds;

import java.util.Objects;

/**
 * synchronized 测试
 *
 * @author liu kai
 * @since 2019-11-29 22:32
 */
public class Synchronized01 {

    public static void main(String[] args) {
        SyncTest01 syncTest01 = new SyncTest01();
        Thread t1 = new Thread(syncTest01);
        Thread t2 = new Thread(syncTest01);
        t1.start();
        t2.start();
    }
}


class SyncTest01 implements Runnable {
    private static int value = 10000;
    Object lock = new Object();
    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < 10000; i++) {
                System.out.println(Thread.currentThread().getName() + "----" + value--);
            }
        }
    }
}