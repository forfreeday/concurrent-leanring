package com.liukai.concurrent.queue;


import java.util.HashMap;
import java.util.Map;

/**
 * 自定义线程队列
 * @author liukai
 * @since 2019/7/14 12:53.
 */
public class CustomThreadQueue {

    private static Map<Thread, Object> threadObjectMap = new HashMap<>();
    private static Map<String, Thread> threadObjectMap1 = new HashMap<>();

    public static void main(String[] args)  {


        try {

            MyThread1 thread1 = new MyThread1(threadObjectMap1, "aaaa");
            MyThread1 thread2 = new MyThread1(threadObjectMap1, "bbbb");
            Thread t1 = new Thread(thread1);
            Thread t2 = new Thread(thread2);
            t1.setName("T1");
            t2.setName("T2");
            t1.start();
            t2.start();



            Thread.sleep(1000);

            Thread tmap1 = threadObjectMap1.get("T1");
            Thread tmap2 = threadObjectMap1.get("T2");
            System.out.println("主线程: " + tmap1);
            System.out.println("主线程: " + tmap2);
            System.out.println("唤醒前: " + threadObjectMap1.size());
            thread1.notify();
            thread2.notify();
            System.out.println("唤醒后: " + threadObjectMap1.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }


}


class MyThread1 implements Runnable {



    private Map<String, Thread> threadObjectMap1;

    public MyThread1() {
    }

    public MyThread1(Map<String, Thread> threadObjectMap1, String name) {
        this.threadObjectMap1 = threadObjectMap1;
    }

    @Override
    public void run() {
        test();
    }

    public synchronized void test() {
        System.out.println("MyThread + getName: " + Thread.currentThread().getName());
        System.out.println("this: " + this);
        System.out.println("currentThread: " + Thread.currentThread());
//        threadObjectMap.put(Thread.currentThread(), Thread.currentThread());
        threadObjectMap1.put(Thread.currentThread().getName(), Thread.currentThread());
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadLocal threadLocal = new ThreadLocal();
//        threadLocal.set();
    }

}