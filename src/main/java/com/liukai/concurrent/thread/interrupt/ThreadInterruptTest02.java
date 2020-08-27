package com.liukai.concurrent.thread.interrupt;

import javafx.concurrent.Task;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 线程中断
 * @author liukai
 * @since 2017/7/4.
 */
public class ThreadInterruptTest02 {

    public static void main(String[] args) {
        BlockingQueue<Task> queue = new LinkedBlockingQueue<>();
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    System.out.println(new Date());
                    System.out.println("111");
                    Task take = queue.take();
                    System.out.println("222");
                } catch (InterruptedException e) {
                    interrupted = true;
                    System.out.println(new Date());
                    e.printStackTrace();
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
