package com.liukai.concurrent.thread.wait.wait.test_wat1;

/**
 * @author liukai
 * @since 2019/6/7 17:48.
 */
public class TestWait1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        synchronized (TestWait1.class) {

            Thread.currentThread();
        }
        System.out.println("线程等待 500ms");
    }
}

