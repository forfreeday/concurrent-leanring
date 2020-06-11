package com.liukai.concurrent.aqs.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition 测试
 *
 * @author liu kai
 * @date 2020-03-05 20:57
 */
public class ConditionTest01 {

    private static final Lock lock = new ReentrantLock();
    private static final Condition testCondition = lock.newCondition();

    public static void main(String[] args) {
        //测试开两个线程，线程A先工作一会，再等待。线程B唤醒 A
        ConditionTest01 conditionTest01 = new ConditionTest01();
        new Thread(() -> {
            conditionTest01.testWait();
        }).start();

        new Thread(() -> {
            conditionTest01.testSign();
        }).start();
    }


    private void testWait() {
        try {
            lock.lock();
            System.out.println("线程启动就休眠" + Thread.currentThread().getName());
            testCondition.await();
            System.out.println("线程被唤醒" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void testSign() {
        try {
            lock.lock();
            for (int i = 0; i < 100; i++) {
                Thread.sleep(10);
                System.out.println("线程" + Thread.currentThread().getName() + "工作中");
            }
            System.out.println("工作完成，唤醒等待的线程");
            testCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
