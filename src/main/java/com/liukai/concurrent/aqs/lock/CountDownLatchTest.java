package com.liukai.concurrent.aqs.lock;

//import com.utils.ThreadUtil;

import java.util.concurrent.CountDownLatch;

/**
 * 思路:
 *      1.并发三条线程名为: 线程1、线程2、线程3，同时执行
 *      2.执行顺序:线程1执行后，其他两条线程也执行直到结束，线程1再执行
 * Created by kayle on 2016/8/14.
 */
public class CountDownLatchTest {
    private static final CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        new CountThread1("Thread1", 1000).start();
        new CountThread2("Thread2", 3000).start();
        new CountThread3("Thread3", 3000).start();
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
                System.out.println("【" + name + "】 started");
                countDownLatch.await();
                System.out.println("【" + name + "】 end");
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
            System.out.println("【" + name + "】 started");
//            ThreadUtil.sleep(second);
            countDownLatch.countDown();
            System.out.println("【" + name + "】 end");
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
            System.out.println("【" + name + "】 started");
//            ThreadUtil.sleep(second);
            countDownLatch.countDown();
            System.out.println("【" + name + "】 end");
        }
    }
}