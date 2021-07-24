package com.liukai.concurrent.aqs.lock.reentrantlock.test0;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {

        } finally {
            lock.unlock();
        }
    }
}
