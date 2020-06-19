package com.liukai.concurrent.thread.join;

public class JoinB implements Runnable {
    private Thread thread1;

    public JoinB(){}

    public JoinB(Thread thread1) {
        this.thread1 = thread1;
    }

    @Override
    public void run() {
        try {
            System.out.println("thread2 线程启动");
            System.out.println("thread2 调用 thread1.join 方法， 并等待 thread1 执行结束后执行");
            MyThread myThread = new MyThread();
            myThread.test();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("thread2 -> " + i);
        }
    }

}
