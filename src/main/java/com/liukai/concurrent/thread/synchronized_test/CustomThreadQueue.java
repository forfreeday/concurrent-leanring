package com.liukai.concurrent.thread.synchronized_test;

public class CustomThreadQueue {
    Object object = new Object();

    //同步代码块方式
    public void testLock() {
        //对象锁
        synchronized (object) {

        }
    }


    //同步代码块方式
    public void testLock1() {
        //类锁
        synchronized (Synchronized01.class) {

        }
    }
}