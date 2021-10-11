package com.liukai.concurrent.thread.wait.wait.test2;


public class Test1 {

  public static void main(String[] args) {
    Test2 testWait = new Test2();
    Thread t1 = new Thread(testWait);
//    Thread t2 = new Thread(test1);

    t1.start();
//    t2.start();
  }
}


class Test2 implements Runnable {

  public synchronized void notifySelf(){
    System.out.println("notify，thread: " + Thread.currentThread().getName());
    this.notify();
  }

  public synchronized void waitSelf(){
    try {
      System.out.println("wait，thread: " + Thread.currentThread().getName());
      this.wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  @Override
  public void run() {
    System.out.println("current thread: " + Thread.currentThread().getName());
    waitSelf();
    notifySelf();
  }
}
