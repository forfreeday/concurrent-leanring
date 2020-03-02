//package com.liukai.concurrent.thread.join;
//
///**
// * @author liukai
// * @since 2019/6/7 16:05.
// */
//public class JoinTest {
//
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new Thread(new JoinA());
//        thread1.start();
//        System.out.println("主线程交换执行权");
//        thread1.join();
//        System.out.println("主线程重新获得执行权");
//        Thread thread2 = new Thread(new JoinB());
//        thread2.start();
//    }
//
//
//}
//
//
//class JoinA implements Runnable {
//
//    @Override
//    public void run() {
//        for (int i = 0; i<10; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("joinA -> " + i);
//        }
//    }
//}
//
//
//class JoinB implements Runnable {
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("joinB -> " + i);
//        }
//    }
//}