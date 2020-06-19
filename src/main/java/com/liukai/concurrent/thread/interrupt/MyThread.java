package com.liukai.concurrent.thread.interrupt;

/**
 * 主动中断线程
 */
public class MyThread extends Thread {
    @Override
    public void run(){
        super.run();

        try {
            for(int i=0; i<5000; i++){
                if (i == 100) {
                    System.out.println("主动中断线程");
                    Thread.currentThread().interrupt();
                }
                System.out.println("i="+(i+1));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Run {
    public static void main(String args[]){
        Thread thread = new MyThread();
        thread.start();
//        thread.interrupt();
    }
}