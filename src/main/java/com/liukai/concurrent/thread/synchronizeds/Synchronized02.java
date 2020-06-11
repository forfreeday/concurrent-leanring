package com.liukai.concurrent.thread.synchronizeds;

/**
 * 修饰方法
 *
 * @author liu kai
 * @date 2020-03-27 01:04
 */
public class Synchronized02 {

    public static void main(String[] args) {
        SyncTest02 syncTest01 = new SyncTest02();
        Thread t1 = new Thread(syncTest01);
        Thread t2 = new Thread(syncTest01);
        t1.start();
        t2.start();
    }

}

class SyncTest02 implements Runnable {
    private static int value = 10000;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        testLock1();
    }

    private synchronized void testLock1() {
        while (value > 0) {
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + "------" + (value--));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
