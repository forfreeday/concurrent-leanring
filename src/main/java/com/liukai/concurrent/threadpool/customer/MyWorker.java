package com.liukai.concurrent.threadpool.customer;

import java.util.List;

/**
 * 自定义线程类
 *
 * @author liu kai
 * @date 2020-02-23 23:31
 */
public class MyWorker extends Thread {

    private String name;

    private List<Runnable> runnableList;


    public MyWorker(String name, List<Runnable> runnableList) {
        super(name);
        this.runnableList = runnableList;
    }

    @Override
    public void run() {
        while (runnableList.size() > 0) {
            Runnable r = runnableList.remove(0);
            r.run();
        }
    }

}
