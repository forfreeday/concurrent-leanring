package com.liukai.concurrent.thread.thread_local;

/**
 * Created by kayle on 16/8/20.
 */
public class ThreadLocalTest {
    ThreadLocal<Integer> testThread = new ThreadLocal<Integer>();
    ThreadLocal<String> threadLocalStart = new ThreadLocal<String>();
    ThreadLocal<String> threadLocalEnd = new ThreadLocal<String>();



    public void set(Integer number) {
        threadLocalStart.set("线程开始--->" + Thread.currentThread().getName());
        testThread.set(number);
        threadLocalEnd.set("线程结束--->" + Thread.currentThread().getName());
    }

    public Integer get() {
        System.out.println(threadLocalStart.get());
        System.out.println(testThread.get());
        System.out.println(threadLocalEnd.get());
        return testThread.get();
    }


    public static void main(String[] args) {
        final ThreadLocalTest test = new ThreadLocalTest();
        test.set(11111111);
        test.get();

        Thread thread1 = new Thread() {
            public void run() {
                test.set(22222222);
                test.get();
            }
        };
        thread1.start();
    }
}
