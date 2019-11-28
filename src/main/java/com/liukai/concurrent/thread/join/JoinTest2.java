package com.liukai.concurrent.thread.join;

/**
 * @author liukai
 * @since 2019/6/7 16:05.
 */
public class JoinTest2 {


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new JoinA());
        thread1.start();
        Thread thread2 = new Thread(new JoinB(thread1));
        thread2.start();
    }


}


class JoinA implements Runnable {

    @Override
    public void run() {
        System.out.println("thread1 线程启动");
        for (int i = 0; i<10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1 -> " + i);
        }
    }
}


class JoinB implements Runnable {
    private Thread thread1;

    public JoinB(Thread thread1) {
        this.thread1 = thread1;
    }

    @Override
    public void run() {
        try {
            System.out.println("thread2 线程启动");
            System.out.println("thread2 调用 thread1.join 方法， 并等待 thread1 执行结束后执行");
            MyThread myThread = new MyThread();
            myThread.test();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("thread2 -> " + i);
        }
    }

}

class MyThread {

    public void test() {
        System.out.println(this.getClass().getName());
    }
}