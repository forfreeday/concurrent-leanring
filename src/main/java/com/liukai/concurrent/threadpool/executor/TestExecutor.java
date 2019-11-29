package com.liukai.concurrent.threadpool.executor;

import java.util.concurrent.*;

/**
 * Created by kayle on 2016/12/15.
 * 线程池
 */
public class TestExecutor {

    public static void main(String[] args) {
        //singleTask();     //单任务线程
//        multiTask();        //固定大小
//        elasticTask();
        multiDelayTask();
        delayTask();
    }

    /**
     * Description: 多任务线程池
     * @Author kayle
     * @Data 2016/12/16 10:12
     * @param
     * @return void
     */
    public static void multiTask  () {
        ExecutorService pool = Executors.newFixedThreadPool(5);     //创建固定大小线程池
        for (int i = 0; i < 100; i++) {
            pool.submit(new MyThread());
        }
        pool.shutdown();
    }

    /**
     * Description: 单任务线程池
     * @Author kayle
     * @Data 2016/12/16 10:12
     * @param
     * @return void
     */
    public static void singleTask () {
        ExecutorService pool = Executors.newSingleThreadExecutor(); //创建单一线程池。
        for (int i = 0; i < 100; i++) {
            pool.submit(new MyThread());
        }
        pool.shutdown();
    }

    /**
     * Description: 可变线尺寸多任务程池
     * @Author kayle
     * @Data 2016/12/16 10:12
     * @param
     * @return void
     */
    public static void elasticTask () {
        ExecutorService pool = Executors.newCachedThreadPool();     //可变尽寸线程池
        for (int i = 0; i < 10; i++) {
            pool.submit(new MyThread());
        }
        pool.shutdown();
    }

    /**
     * Description: 多任务延迟线程池
     *          设置线程延迟执行
     * @Author kayle
     * @Data 2016/12/15 18:47
     * @param
     * @return void
     */
    public static void multiDelayTask () {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(6);
   /*     for (int i = 0; i < 10; i++) {
            pool.submit(new MyThread());
        }*/
       pool.schedule(new MyThread(), 1000000, TimeUnit.MICROSECONDS);
       pool.schedule(new MyThread(), 1000000, TimeUnit.MICROSECONDS);
       pool.shutdown();
    }

    /**
     * Description: 单任务延迟线程池
     * @Author kayle
     * @Data 2016/12/16 10:20
     * @param
     * @return void
     */
    public static void delayTask() {
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        for (int i = 0; i < 10; i++) {
            pool.submit(new MyThread());
        }
        pool.schedule(new MyThread(), 1000000, TimeUnit.MICROSECONDS);
        pool.schedule(new MyThread(), 1000000, TimeUnit.MICROSECONDS);
        pool.shutdown();
    }

    public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                threadFactory);
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("当前线程--->" + Thread.currentThread().getName());
    }
}