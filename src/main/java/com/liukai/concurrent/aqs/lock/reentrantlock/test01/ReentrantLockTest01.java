package com.liukai.concurrent.aqs.lock.reentrantlock.test01;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单的锁示例
 * @author liukai
 * @date 2020/8/27 18:23.
 */
public class ReentrantLockTest01 extends Thread {

    public static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;

    public ReentrantLockTest01(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        test1();
    }

    //tryLock
    public void test2() {
        if (lock.tryLock()) {

        }
    }

    //使用 lock 锁位
    public void test1() {
        lock.lock();
        try {
            for (int j = 0; j < 1000; j++) {
                System.out.println(getName() + "-----" + i);
                i++;
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockTest01 reentrantLockTest01 = new ReentrantLockTest01("test01");
        reentrantLockTest01.start();
    }
}
