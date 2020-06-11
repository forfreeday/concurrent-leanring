package com.liukai.concurrent.threadpool.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableTest {
    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService pools = Executors.newFixedThreadPool(5);
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        //创建多个有返回值的任务
        for (int i = 0; i <= 10; i++) {
            Future<Integer> futures = pools.submit(new Task(i));
            list.add(futures);
        }
        for (Future<Integer> f : list) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
		}
        pools.shutdown();
    }
}

class Task implements Callable<Integer> {
    private Integer taskID;

    public Task(Integer taskID) {
        this.taskID = taskID;
    }

    @Override
    public Integer call() throws Exception {
        if (taskID.equals(3)) {
			Thread.sleep(100);
		}
        System.out.println("任务[" + taskID + "]开始执行");
        return taskID;
    }
}
