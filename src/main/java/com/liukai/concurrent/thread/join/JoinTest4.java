package com.liukai.concurrent.thread.join;

/**
 * Created by liukai on 2016/12/16.
 * 这个例子是一个有疑问的例子：
 *      主线程 join 后，子线程再 join，线程就死锁，这是为什么？
 */
public class JoinTest4 {
    public static void main(String[] args) throws InterruptedException {
        JoinObject joinObject = new JoinObject();
        joinObject.setMainThread(Thread.currentThread());
        Thread joinThread = new Thread(joinObject);

        for (int i = 0; i < 1000 ; i++) {
            Thread.sleep(100);
            System.out.println("主线程--->" + Thread.currentThread().getName() + "--->" + i);
            if (i == 50) {
                System.out.println("交换执行权");
                joinThread.start();
                joinThread.join();
            }
        }
        System.out.println(".........主线程执行完毕............");
    }
}

/**
 * Description:
 * @author liukai
 * @since  2016/12/16 15:32
 */
class JoinObject implements Runnable {
    private Thread mainThread;
    public void run() {
        for (int i = 0; i < 500; i++) {
            try {
                Thread.sleep(100);
                System.out.println("子线程--->" + Thread.currentThread().getName() + "--->" + i);
                if (i == 100) {
                    System.out.println("再次交换执行权给--->" + mainThread.getName());
                    mainThread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setMainThread(Thread mainThread) {
        this.mainThread = mainThread;
    }
}