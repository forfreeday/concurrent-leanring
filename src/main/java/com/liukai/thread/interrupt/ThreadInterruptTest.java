package com.liukai.thread.interrupt;

import javafx.concurrent.Task;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description
 * @author liukai
 * @since 2017/7/4.
 */
public class ThreadInterruptTest {

    public static void main(String[] args) {
        BlockingQueue<Task> queue = new LinkedBlockingQueue<Task>();
        boolean interrupted = false;
        try {
            while (true) {
                try {
                    System.out.println("111");
                    queue.take();
                    System.out.println("222");
                } catch (InterruptedException e) {
                    interrupted = true;
                }
            }
        } finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
