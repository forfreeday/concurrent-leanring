package com.liukai.concurrent.thread.synchronized_test;

public class Synchronized03 {
    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }
}