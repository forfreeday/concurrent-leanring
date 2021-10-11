package com.liukai.concurrent.thread.wait.wait.exception;

/**
 * 解决问题
 * @author liukai
 * @since 2019/7/14 16:37.
 */
public class WaitTest2 {

    public static void main(String[] args) {
        final WaitTest2 test = new WaitTest2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test.testWait();
            }
        }).start();
    }


    public synchronized void testWait(){
        //增加Synchronized关键字
        System.out.println("Start-----");
        try {
            wait(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End-------");
    }

}
