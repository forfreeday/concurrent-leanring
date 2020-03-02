package com.liukai.concurrent.threadpool.customer;

/**
 * 自定义任务类
 *      1.任务编号
 *      2.执行时间
 * @author liu kai
 * @date 2020-02-23 23:32
 */
public class MyTask implements Runnable{
    /**
     *
     * 线程编号
     */
    private int id;

    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {


        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程:" +  Thread.currentThread().getName() + "执行, id: " + id);
    }
}
