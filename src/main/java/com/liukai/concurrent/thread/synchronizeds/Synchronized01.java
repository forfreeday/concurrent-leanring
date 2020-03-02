package com.liukai.concurrent.thread.synchronizeds;

/**
 * synchronized 测试
 *
 * @author liu kai
 * @since 2019-11-29 22:32
 */
public class Synchronized01 {

    public synchronized void testLock01() {
        SyncTest syncTest = new SyncTest();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(syncTest);
            System.out.println(thread.getName());
            System.out.println(i);
            thread.start();
        }
    }

    public synchronized void testLock02() {
        SyncTest syncTest = new SyncTest();
        Thread thread1 = new Thread(syncTest);
        Thread thread2 = new Thread(syncTest);
        Thread thread3 = new Thread(syncTest);
        Thread thread4 = new Thread(syncTest);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Synchronized01 synchronized01 = new Synchronized01();
//        synchronized01.testLock01();
        synchronized01.testLock02();
    }
}


class SyncTest implements Runnable {

    Object object = new Object();
    private static int value = 10000;


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
//        testLock1();
//        testLock2();
        testLock3();
    }

    //同步代码块方式
    public synchronized void testLock1() {
        while (value > 0) {
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + "------" + (value--));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //同步代码块方式
    public void testLock2() {
        //对象锁
        while (value > 0) {
            synchronized (Synchronized01.class) {
//            synchronized (Synchronized02.class) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "------" + (value--));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void testLock3() {
        while (value > 0) {
            synchronized (object) {
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