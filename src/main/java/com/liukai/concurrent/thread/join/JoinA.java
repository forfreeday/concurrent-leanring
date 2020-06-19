package com.liukai.concurrent.thread.join;

public class JoinA implements Runnable {

    @Override
    public void run() {
        System.out.println("thread1 线程启动");
        for (int i = 0; i<1000; i++) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("thread1 -> " + i);
        }
    }
}
