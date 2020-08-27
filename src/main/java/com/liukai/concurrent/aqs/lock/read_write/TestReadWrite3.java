package com.liukai.concurrent.aqs.lock.read_write;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kayle on 2017/2/15.
 * 验证读锁不互斥，写锁之间互斥
 */
public class TestReadWrite3 {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private double writeDate;

    public static void main(String[] args) {
        TestReadWrite3 testReadWriteLock = new TestReadWrite3();
        for (int i = 0; i < 10; i++) {
            //读
            new Thread(new Runnable() {
                public void run() {
                    testReadWriteLock.readLock();
                }
            }).start();
            //写
            new Thread(new Runnable() {
                public void run() {
                    testReadWriteLock.writeLock();
                }
            }).start();
        }
    }

    public void readLock() {
        //while(true) {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "开始读");
            try {
                Thread.sleep((long)Math.random() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readWriteLock.readLock().unlock();
        //}
    }

    public void writeLock() {
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "：---> 开始写");
        writeDate = Math.random() * 1000;
        System.out.println(Thread.currentThread().getName() + "：--->" + writeDate);
        readWriteLock.writeLock().unlock();
    }
}
