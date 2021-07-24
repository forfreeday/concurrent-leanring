package com.liukai.concurrent.aqs.lock.reentrantlock.test1;

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
