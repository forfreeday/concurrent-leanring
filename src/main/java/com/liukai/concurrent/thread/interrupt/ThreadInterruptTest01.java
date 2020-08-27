package com.liukai.concurrent.thread.interrupt;

/**
 * 停止线程，使用interrupte()
 * 
 * @author lxy
 * 
 */
public class ThreadInterruptTest01 {

    public static void main(String[] args) {
        StopThread st = new StopThread();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        t1.start();
        t2.start();

        for (int i = 0; i < 50; i++) {
            if (i == 49) {
                // 这里要使用interrupte()方法。
                // 来唤醒在wait的线程1和线程2
                // st.stopThread();
                t1.interrupt();
                t2.interrupt();
            }
            System.out.println("mainThread..." + i);
        }
    }
}

class StopThread implements Runnable {
    private boolean flag = true;

    @Override
    public synchronized void run() {
        while (flag) {

            try {
                wait();
            } catch (InterruptedException e) {
                // 线程被强制唤醒（改变状态）之后，会产生InterruptedException
                System.out.println(Thread.currentThread().getName() + "....."
                        + e);
                // 要在这里将flag设为false，不然一直会执行。
                flag = false;
            }
            System.out.println(Thread.currentThread().getName() + " ....+++=");
        }
    }

    public void stopThread() {
        flag = false;
    }
}