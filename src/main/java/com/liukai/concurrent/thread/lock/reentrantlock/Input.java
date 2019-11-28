package com.liukai.concurrent.thread.lock.reentrantlock;
public class Input implements Runnable{
       private Resource res;
       public Input(Resource res) {
               this.res = res;
       }
       
       @Override
       public void run() {
               while (true) {
                       res.set();
               }
       }
}

