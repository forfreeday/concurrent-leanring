package com.liukai.concurrent.aqs.lock.reentrantlock;

public class Test {
       public static void main(String[] args) {
               Resource r = new Resource();
               Input in = new Input(r);
               Output out = new Output(r);
               
               Thread t1 = new Thread(in);
               Thread t2 = new Thread(in);
               Thread t3 = new Thread(out);
               Thread t4 = new Thread(out);
               
               t1.start();
               t2.start();
               t3.start();
               t4.start();
       }
}