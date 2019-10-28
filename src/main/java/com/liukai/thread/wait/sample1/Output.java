package com.liukai.thread.wait.sample1;


/**
 * Created by kayle on 2016/12/16.
 */
public class Output implements Runnable {
    private final TestWait testWait;
    public void run() {
        int i = 0;
        while (!testWait.isRunning()) {
            try {
                Thread.sleep(300);
                System.out.println(Thread.currentThread().getName());
                i++;
                if (i % 5 == 0) {
                    testWait.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testWait.notify();
        }

    }

    public Output(TestWait testWait) {
        this.testWait = testWait;
    }
}
