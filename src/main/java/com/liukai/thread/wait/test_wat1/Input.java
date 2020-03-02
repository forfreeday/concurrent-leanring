package com.liukai.thread.wait.test_wat1;


/**
 * Created by kayle on 2016/12/16.
 */
public class Input implements Runnable{
    private final TestWait testWait;

    public Input(TestWait testWait) {
        this.testWait = testWait;
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                if (testWait.isRunning()) {
                    Thread.sleep(300);
                    System.out.println(Thread.currentThread().getName());
                    i++;

                    if (i % 5 == 0) {
                        testWait.wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testWait.notify();
        }
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
