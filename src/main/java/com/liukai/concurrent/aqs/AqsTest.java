package com.liukai.concurrent.aqs;

/**
 * AQS 测试
 *
 * @author liu kai
 * @date 2020-06-12 10:45
 */
public class AqsTest {
    static Thread thread;
    public static void main(String[] args) {
        thread = Thread.currentThread();
        System.out.println(thread.getName());
    }

}

