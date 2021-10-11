package com.liukai.concurrent.thread.wait.wait.exception;

//演示问题
public class WaitTest {

  public void testWait() {
    System.out.println("Start-----");
    try {
      wait(1000);  //没有一个锁对象，所以报错！！！
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("End-------");
  }

  public static void main(String[] args) {
    final WaitTest test = new WaitTest();
    new Thread(new Runnable() {
      @Override
      public void run() {
        test.testWait();
      }
    }).start();
  }
}
