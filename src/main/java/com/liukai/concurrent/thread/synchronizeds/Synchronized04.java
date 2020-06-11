package com.liukai.concurrent.thread.synchronizeds;

/**
 * Created by kayle on 2016/12/20.
 * 证明 synchronized 代码块 与 synchronized 方法使用的都是同一把锁
 */
public class Synchronized04 {

    public static void main(String[] args) {
        new Synchronized04().init();
        //final Output output = new Output();
        // 在静态方法中不能 new 内部类的实例对象。因为，内部类的最重要的特点就是可以访问外部类的成员变量。
        // 可以访问成变量意就意味着这个对象是已经创建了的。但是，静态方法中不再要创建对象也可以访问，这就产生了矛盾。
        // 解决方法：1.将内部类置为静态内部类。
        //           2.通过对象调用。
    }


    private void init() {
        final Output output = new Output();
        new Thread(() -> {
            while (true) {
                output.outer1("test");
            }
        }).start();

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    output.outer2("practise");
                }
            }
        }.start();

    }

    class Output {
        int i = 0;
        public void outer1(String name) {

            try {
                synchronized (this) {
                    Thread.sleep(10);
                    System.out.println(name + "--->" + i++);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void outer2(String name) {
            System.out.println(name + "--->" + i++);
        }
    }

}
