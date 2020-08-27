package com.liukai.concurrent.threadpool.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest01 {
    public static void main(String[] args) {
        ThreadDemoCa td = new ThreadDemoCa();

        //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
        FutureTask<Integer> result1 = new FutureTask<>(td);
        FutureTask<Integer> result2 = new FutureTask<>(td);
        FutureTask<Integer> result3 = new FutureTask<>(td);

        new Thread(result1).start();
        new Thread(result2).start();
        new Thread(result3).start();
        try {
            result1.get();
            result2.get();
            result3.get();
            //2.接收所有线程运算后主线程才执行
            System.out.println("主线程执行");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ThreadDemoCa implements Callable<Integer> {

    //需要实现call()方法
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "执行结束");
        return 1;
    }

}