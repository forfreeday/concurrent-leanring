package com.liukai.concurrent.thread.wait.example1;

/**
 * description  TODO
 *
 * @author liu kai
 * @since 2019-10-28 20:55
 */
public class SimpleWaitTest implements Runnable {

    private Object object;

    public SimpleWaitTest(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        testMethod(object);
    }

    public void testMethod(Object lock) {
        synchronized (lock) {
            try {
                System.out.println("testMethod begin " + Thread.currentThread().getName());
                //1. 锁住自己
                lock.wait();
                System.out.println("testMethod be notify " + Thread.currentThread().getName());
                //4.唤醒 wait 线程
                lock.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public void setObject(Object object) {
        this.object = object;
    }
}
