package com.liukai.concurrent.aqs.lock.read_write;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kayle on 2017/2/12.
 *  测试读写锁
 */
public class TestReadWrite {
    private double writeDate;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final TestReadWrite testReadWrite = new TestReadWrite();
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {

                public void run() {
                    while (true) {
                        testReadWrite.read();
                    }
                }
            }).start();
            new Thread(new Runnable() {

                public void run() {
                    while (true) {
                        testReadWrite.write((int) (Math.random() * 1000));
                    }
                }
            }).start();
        }
    }

        //读
    public void read() {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " be ready to read data!");
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "have read data :" + writeDate);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    //写
    public void write(int random) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "：---> 开始写");
            this.writeDate = random;
            System.out.println(Thread.currentThread().getName() + "：---> 写的结果" + writeDate);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}
