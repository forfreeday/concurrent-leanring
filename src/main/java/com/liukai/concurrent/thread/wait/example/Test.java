package com.liukai.concurrent.thread.wait.example;



/**
 * Created by kayle on 2016/12/16.
 */
public class Test {

    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        SimpleWaitTest simpleWaitTest = new SimpleWaitTest(object);
        SimpleNotifyTest simpleNotifyTest = new SimpleNotifyTest(object);

        new Thread(simpleWaitTest).start();
        Thread.sleep(100);
        new Thread(simpleNotifyTest).start();

    }
}
