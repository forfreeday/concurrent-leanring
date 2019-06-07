package com.liukai.thread.atomic;

/**
 * @author liukai
 * @data 2018/10/4 23:08.
 */
public class GeneralUnsafeThread implements Runnable {


    private static boolean isExits = false;
    private String name;


    GeneralUnsafeThread(String name) {
        this.name = name;
    }

    /**
     * 普通的线程标识方法
     *
     * author liukai
     * date 2018/10/4 21:38
     *
     * @param
     * @return void
     */
    public  void run() {
        if (!isExits) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + name);
            System.out.println(Thread.currentThread().getName() + name);
            isExits = true;
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程睡眠后" + Thread.currentThread().getName() + name);
            System.out.println("线程睡眠后" + Thread.currentThread().getName() + name);
            isExits = true;
        }else{
            //线程不会进入这个 else
            System.out.println("线程失败" + name);
        }
    }

}
