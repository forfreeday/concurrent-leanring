package com.liukai.concurrent.thread.join;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println("新线程执行--->" + Thread.currentThread().getName() + "--->" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        for (int i = 0; i < 100; i++) {
            Thread.sleep(200);
            System.out.println("当前线程--->" + Thread.currentThread().getName() + "--->" + i);
            if (i == 50) {
                System.out.println("main 线程交换执行权");
                t1.start();
                t1.join();                //不设置时间，就等到子线程结束。
            }
        }
        System.out.println(".........主线程执行完毕............");
    }
}