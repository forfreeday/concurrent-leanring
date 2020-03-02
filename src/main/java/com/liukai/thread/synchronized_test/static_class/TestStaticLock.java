package com.liukai.thread.synchronized_test.static_class;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kayle on 2017/5/26.
 */
public class TestStaticLock {
    public static int num = 100;
    //失败的例子
    public synchronized int fail() {
        int i = 0;
        while (i < 10) {
            try {
                num --;
                i++;
                System.out.println(Thread.currentThread().getName()+":"+num);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return num ;
    }

    //成功的例子
    public int success() {
        int i = 0;
        synchronized (TestStaticLock.class) {
            while (i < 10) {
                try {
                    num --;
                    i++;
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return num ;
    }
    //等价于上面的方法
//    public static synchronized int success() {
//        int i = 0;
//        while (i < 10) {
//            try {
//                num --;
//                i++;
//                System.out.println(Thread.currentThread().getName()+":"+num);
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        return num ;
//    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new JustRun());
        Thread t2 = new Thread(new JustRun());
        //1. 普通的线程执行方式
//        t1.start();
//        t2.start();
        //2. 线程池方式
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(t1);
        es.execute(t2);
        es.shutdown();

    }
}


// 先建立两个测试类，这里我们默认循环10次
class JustRun implements Runnable {

    public void run() {
        TestStaticLock walk = new TestStaticLock();
        //成功
//        walk.success();
        //失败
        walk.fail();
    }
}