package com.liukai.concurrent.thread.daed_lock;

/**
 * 死锁
 */
public class SyncDeadLock {
  private static Object locka = new Object();
  private static Object lockb = new Object();

  public static void main(String[] args) {
    new SyncDeadLock().deadLock();
  }

  private void deadLock() {

    Thread thread1 = new Thread(() -> {
      synchronized (locka) {
        try {
          System.out.println(Thread.currentThread().getName() + " 拿到 lock-A!");
          Thread.sleep(500);
          System.out.println(Thread.currentThread().getName() + " 睡眠 500ms 后续继执行...!");
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 偿试获取 lock-B!");
        synchronized (lockb) {
          System.out.println(Thread.currentThread().getName() + " 已获得 lock-B!");
        }
      }
    }, "thread1");

    Thread thread2 = new Thread(() -> {
      synchronized (lockb) {
        try {
          System.out.println(Thread.currentThread().getName() + " 拿到 lock-B!");
          Thread.sleep(500);
          System.out.println(Thread.currentThread().getName() + " 睡眠 500ms 后续继执行...!");
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 偿试获取 lock-A!");
        synchronized (locka) {
          System.out.println(Thread.currentThread().getName() + " 已获得 lock-A!");
        }
      }
    }, "thread2");

    thread1.start();
    thread2.start();
  }
}
