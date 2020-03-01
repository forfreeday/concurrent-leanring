package com.liukai.concurrent.thread.synchronizeds;

/**
* 静态方法锁
*      如果你是synchronized加在静态方法上，那么锁就是当前类的class对象，但是如果是在静态方法内部的静态语句块，那么锁对象就可以是任意的可引用的对象。
* 如果是加在非静态方法上，那么锁对象就是当前this对象。
* @author liukai
* @data 2018/12/25 11:34.
*/
public class Synchronized02 {

  private static String dataStatic = "lock1";

  //静态方法上的同步，那么锁就是默认的当前TestStaticLock2.class对象
  public static synchronized void testStatic1(){

  }

  public static void testStatic2(){
      synchronized(Synchronized02.class){

      }
  }

  public static synchronized void testStatic3(){
      synchronized (dataStatic) {
          //
      }
  }
  public static synchronized void testStatic4(){
      Synchronized02 test = new Synchronized02();
      synchronized(test.getClass()){
          //
      }
  }

}