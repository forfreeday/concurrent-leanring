package com.liukai.concurrent.aqs.lock;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    static class TaskThread extends Thread {
        CyclicBarrier barrier;
        
        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }
        
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + " 到达栅栏 A");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");
                
                Thread.sleep(2000);
                System.out.println(getName() + " 到达栅栏 B");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    static int threadNum = 5;
    static CyclicBarrier barrier = new CyclicBarrier(threadNum, () -> System.out.println(Thread.currentThread().getName() + " 完成最后任务"));

    public static void main(String[] args) {

        for(int i = 0; i < threadNum; i++) {
//        for(int i = 0; i < 10; i++) {
            new TaskThread(barrier).start();
        }
    }
    
}