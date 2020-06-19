package com.liukai.concurrent.thread.join;

/**
 * @author liukai
 * @since 2019/6/7 16:05.
 */
public class JoinTest02 {


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new JoinA());
        thread1.start();
        Thread thread2 = new Thread(new JoinB(thread1));
        thread2.start();
    }


}



class MyThread {

    public void test() {
        System.out.println(this.getClass().getName());
    }
}