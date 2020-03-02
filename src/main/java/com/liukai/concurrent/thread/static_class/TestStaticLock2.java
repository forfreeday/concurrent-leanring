package com.liukai.concurrent.thread.static_class;

/**
 * 静态方法锁
 *      如果你是synchronized加在静态方法上，那么锁就是当前类的class对象，但是如果是在静态方法内部的静态语句块，那么锁对象就可以是任意的可引用的对象。
 * 如果是加在非静态方法上，那么锁对象就是当前this对象。
 * @author liukai
 * @data 2018/12/25 11:34.
 */
public class TestStaticLock2 {

    private static String dataStatic = new String("lock1");

    //静态方法上的同步，那么锁就是默认的当前TestStaticLock2.class对象
    public static synchronized void testStatic1(){

    }

    public static void testStatic2(){
        synchronized(TestStaticLock2.class){

        }
    }

    public static synchronized void testStatic3(){
        synchronized (dataStatic) {
            //
        }
    }
    public static synchronized void testStatic4(){
        TestStaticLock2 test = new TestStaticLock2();
        synchronized(test.getClass()){
            //
        }
    }


    public static void main(String[] args) {

    }

}
