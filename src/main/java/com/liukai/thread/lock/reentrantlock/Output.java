package com.liukai.thread.lock.reentrantlock;

public class Output implements Runnable{
       Resource res;
       public Output(Resource res) {
               this.res = res;
       }
       
       @Override
       public void run() {
               while (true) {
                       res.out();
               }
       }
}
