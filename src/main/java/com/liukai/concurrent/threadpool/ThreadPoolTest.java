package com.liukai.concurrent.threadpool;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author liukai
 * @data 2019/4/25 10:36.
 */
public class ThreadPoolTest {

    private static int corePoolSize = 10;
    private static int maximumPoolSize = 50;
    private static int keepAliveTime = 100000;
    private ArrayBlockingQueue workQueue = new ArrayBlockingQueue(20);


    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newFixedThreadPool(10);


//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
    }
}
