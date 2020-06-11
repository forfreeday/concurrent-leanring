package com.liukai.concurrent.thread.wait.example1;

/**
 * description  TODO
 *
 * @author liu kai
 * @since 2019-10-28 20:55
 */
public class SimpleNotifyTest implements Runnable {

    private Object object;

    public SimpleNotifyTest(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        syncMethod(object);
    }


    public void syncMethod(Object lock) {
        synchronized (lock) {
            try {
                System.out.println("syncMethod begin " + Thread.currentThread().getName());
                //2.唤醒 wait 线程后 wait
                lock.notify();
                //3.wait 住，等待唤醒
                lock.wait();
                System.out.println("syncMethod be notify " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
