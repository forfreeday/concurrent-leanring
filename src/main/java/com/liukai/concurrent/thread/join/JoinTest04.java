package com.liukai.concurrent.thread.join;

public class JoinTest04 {

    static class ThreadDemo implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 200; i++) {
                    System.out.println(Thread.currentThread().getName() + "--" + i);
                }
                System.out.println(Thread.currentThread().getName() + "执行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        try {
            Thread thread1 = new Thread(td);
            Thread thread2 = new Thread(td);
            Thread thread3 = new Thread(td);
            thread1.start();
            thread2.start();
            thread3.start();
            //让三个线程执行完，如果在调用start方法后面直接调用join方法，那么三个线程将串行
            System.out.println("join1");
            thread1.join();
            System.out.println("join2");
            thread2.join();
            System.out.println("join3");
            thread3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程结束执行");
    }

}

