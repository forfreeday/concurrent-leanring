package com.liukai.thread.static_class;

/**
 * @author liukai
 * @data 2019/4/23 15:26.
 */
public class SafeTest {



    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 500; i++) {
            Thread.sleep(100);
            User user = new User(i);
            new Thread(user).start();
        }
    }


    public static void testMethod(int i) {
        System.out.println(i);
    }
}

class User implements Runnable {

    private int number;

    public User() {

    }

    public User(int number) {
        this.number = number;
    }

    public void take() {
        SafeTest.testMethod(number);
    }

    @Override
    public void run() {
        take();
    }
}