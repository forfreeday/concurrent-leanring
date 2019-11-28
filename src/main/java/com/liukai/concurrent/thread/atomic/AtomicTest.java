package com.liukai.concurrent.thread.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicTest implements Runnable{
    private static int i = 0;
    private static AtomicBoolean bool = new AtomicBoolean(false);
    private String name;
    AtomicTest(String name){
        this.name = name;
    }


    public  void run() {
            if (bool.compareAndSet(false,true)) {
                ++i;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + name);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + name);
                System.out.println(i);
                bool.set(false);
            }else{
                System.out.println(Thread.currentThread().getName() + name + " 线程进入另一个业务线");
            }
    }
}