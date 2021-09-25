package com.liukai.concurrent.aqs.lock.reentrantlock.test02;

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
