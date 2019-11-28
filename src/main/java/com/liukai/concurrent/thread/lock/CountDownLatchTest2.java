package com.liukai.concurrent.thread.lock;

//import com.utils.ThreadUtil;

import java.util.concurrent.CountDownLatch;

/**
 * 思路:
 *      1.并发三条线程名为: 线程1、线程2、线程3，同时执行
 *      2.执行顺序:线程1执行后，其他两条线程也执行直到结束，线程1再执行
 * Created by kayle on 2016/8/14.
 */
public class CountDownLatchTest2 {
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        new CountThread1("Thread0", 0).start();
        new CountThread2("Thread1", 0).start();
        new CountThread3("Thread2", 0).start();
        new CountThread4("Thread3", 0).start();
        new CountThread5("Thread4", 0).start();
        new CountThread6("Thread5", 0).start();
        countDownLatch.countDown();

    }


    /*
     * 线程1：先执行，然后 await,等待其他线程执行结束
     */
    private static class CountThread1 extends Thread {
        private String name;
        private Integer second;
        public CountThread1 (String name, Integer second) {
            this.name = name;
            this.second = second;
        }

        @Override
        public void run() {
            try {
                System.out.println("【" + Thread.currentThread().getName() + "】 started");
                countDownLatch.await();
//                Thread.currentThread().sleep(1000);
                Thread.sleep(10000);
                System.out.println("【" + Thread.currentThread().getName() + "】 end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    *  线程2
    *
    */
    private static class CountThread2 extends Thread{
        private String name;
        private Integer second;
        public CountThread2 (String name, Integer second) {
            this.name = name;
            this.second = second;
        }

        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(3000);
                System.out.println("【" + Thread.currentThread().getName() + "】 started");
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("【" + Thread.currentThread().getName() + "】 end");
        }
    }

    /*
    * 线程3
    *
    */
    private static class CountThread3 extends Thread{
        private String name;
        private Integer second;
        public CountThread3 (String name, Integer second) {
            this.name = name;
            this.second = second;
        }

        @Override
        public void run() {
            System.out.println("【" + Thread.currentThread().getName() + "】 started");
//            ThreadUtil.sleep(second);
            try {
                Thread.sleep(3000);
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("【" + Thread.currentThread().getName() + "】 end");
        }
    }

    /*
     * 线程3
     *
     */
    private static class CountThread4 extends Thread{
        private String name;
        private Integer second;
        public CountThread4 (String name, Integer second) {
            this.name = name;
            this.second = second;
        }

        @Override
        public void run() {
            System.out.println("【" + Thread.currentThread().getName() + "】 started");
//            ThreadUtil.sleep(second);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("【" + Thread.currentThread().getName() + "】 end");
        }
    }

    /*
     * 线程3
     *
     */
    private static class CountThread5 extends Thread{
        private String name;
        private Integer second;
        public CountThread5 (String name, Integer second) {
            this.name = name;
            this.second = second;
        }

        @Override
        public void run() {
            System.out.println("【" + Thread.currentThread().getName() + "】 started");
//            ThreadUtil.sleep(second);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("【" + Thread.currentThread().getName() + "】 end");
        }
    }

    /*
     * 线程3
     *
     */
    private static class CountThread6 extends Thread{
        private String name;
        private Integer second;
        public CountThread6 (String name, Integer second) {
            this.name = name;
            this.second = second;
        }

        @Override
        public void run() {
            System.out.println("【" + Thread.currentThread().getName() + "】 started");
//            ThreadUtil.sleep(second);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("【" + Thread.currentThread().getName() + "】 end");
        }
    }
}