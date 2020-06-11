package com.liukai.concurrent.thread.synchronizeds;

/**
 * 同步线程
 */
class Synchronized05 implements Runnable {
    private static int count;

    public Synchronized05() {
        count = 0;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + (count++));
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Synchronized05 syncThread1 = new Synchronized05();
        Synchronized05 syncThread2 = new Synchronized05();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}