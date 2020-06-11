package com.liukai.concurrent.thread.synchronizeds;

/**
 * synchronized 测试
 *
 * @author liu kai
 * @since 2019-11-29 22:32
 */
public class Synchronized0001 {

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        Thread t1 = new Thread(syncTest);
        Thread t2 = new Thread(syncTest);
        t1.start();
        t2.start();
    }
}


class SyncTest implements Runnable {
    private static int value = 10000;

    @Override
    public void run() {
        while (value > 0) {
            synchronized (Synchronized01.class) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "------" + (value--));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}