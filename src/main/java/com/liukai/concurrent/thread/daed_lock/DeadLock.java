package com.liukai.concurrent.thread.daed_lock;

/**
 * 模拟死锁
 */
public class DeadLock {
  public static void main(String[] args) {
    Thread thread1 = new Thread(new GotoRun(true));
    Thread thread2 = new Thread(new GotoRun(false));
    thread1.start();
    thread2.start();

  }
}

class MyLock {
  static Object lockA = new Object();
  static Object lockB = new Object();

}

//注意：MyLock.A 和 MyLock.B 是单个资源，两个线程是在持有各自的一个锁的情况下，要去取被对方所占用的那把锁，造成僵持不下的情况。
class GotoRun implements Runnable {
  boolean flag;

  public GotoRun(boolean flag) {
    this.flag = flag;
  }

  public void run() {
    if (flag) {
      synchronized (MyLock.lockA) {                //线程1持有A锁，并进入同步方法内去取B锁，但是B锁被线程2所占用着。
        System.out.println("if lockA");
        synchronized (MyLock.lockB) {
          System.out.println("if lockB");
        }
      }
    } else {
      synchronized (MyLock.lockB) {                //线程2持有B锁，并进入同步方法内去取B锁，但是A锁被线程1所占用着。
        System.out.println("else lockB");        //这里和 if 相反，lockB在前面
        synchronized (MyLock.lockA) {
          System.out.println("else lockA");
        }
      }
    }
  }
}
