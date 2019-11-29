package com.liukai.concurrent.thread.synchronized_test;

/**
 * synchronized 测试
 *
 * @author liu kai
 * @since 2019-11-29 22:32
 */
public class Synchronized01 {
    Object object = new Object();

    //同步代码块方式
    public void testLock() {
        //对象锁
        synchronized (object) {

        }
    }


}
