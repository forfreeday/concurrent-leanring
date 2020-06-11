package com.liukai.concurrent.aqs.atomic;

/**
 *
 * @author liukai
 * @data 2018/10/4 21:37.
 */
public class AtomicBooleanTest {


    public static void main(String[] args) {
        Thread thread1 = new Thread(new AtomicTest("业务-1"));
        Thread thread2 = new Thread(new AtomicTest("业务-2"));

        thread1.start();
        thread2.start();
    }
}
