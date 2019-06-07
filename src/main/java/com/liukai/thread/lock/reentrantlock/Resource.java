package com.liukai.thread.lock.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    private String name;
    private boolean flag;
    private Lock lock = new ReentrantLock();
    private Condition pro_condition = lock.newCondition();
    private Condition cus_condition = lock.newCondition();


    private int count = 0;

    public void set() {
        lock.lock();
        try {
            while (flag) {
                pro_condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "----->" + "生产者" + count);
            flag = true;
            cus_condition.signal();        //使用sinal
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void out() {
        lock.lock();
        try {
            while (!flag) {
                cus_condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "----->" + "消费者" + count++);
            flag = false;
            pro_condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
