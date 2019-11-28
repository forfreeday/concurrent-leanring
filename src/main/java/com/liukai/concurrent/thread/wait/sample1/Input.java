package com.liukai.concurrent.thread.wait.sample1;


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
        synchronized (testWait) {
            while (true) {
                try {
                    if (testWait.isRunning()) {
                        Thread.sleep(300);
                        System.out.println(Thread.currentThread().getName() + " input");
                        i++;

                        if (i % 5 == 0) {
                            testWait.setRunning(false);
                            testWait.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("in-notify");
                testWait.notify();
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}
