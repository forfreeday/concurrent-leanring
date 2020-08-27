package com.liukai.concurrent.thread.wait.example4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liukai
 * @since 2020/7/2 16:35.
 */
public class TestWait4 {

    public static void main(String[] args) {
//        demo3();

        TestWait4 testWait4 = new TestWait4();
        TestWait4 testWait42 = new TestWait4();
        System.out.println(testWait4.hashCode());
        System.out.println(testWait42.hashCode());
        int h;
        String key = "aaa";
        int i = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(i);


        System.out.println(20>>2);
        System.out.println(20>>>5);
    }
    /**
     * A 1, B 1, B 2, B 3, A 2, A 3
     */
    private static void demo3() {
        Object lock = new Object();

        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("A 1");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("A 2");
                    System.out.println("A 3");
                }

            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("B 1");
                    System.out.println("B 2");
                    System.out.println("B 3");

                    lock.notify();
                }
            }
        });

        A.start();
        B.start();

    }

}
