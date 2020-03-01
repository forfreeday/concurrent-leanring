package com.liukai.concurrent.thread.synchronizeds;

public class Synchronized03 {
    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }
}