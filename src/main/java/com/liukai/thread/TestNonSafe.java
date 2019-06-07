package com.liukai.thread;

/**
 * Created by kayle on 2016/12/14.
 */
public class TestNonSafe {
    TestNonSafe.Output output = null;

    public static void main(String[] args) {
        new TestNonSafe().init ();
    }

    public void init () {
        final TestNonSafe.Output output = new Output();
/*        new Thread() {
            @Override
            public void run() {
                output.sendMail(Thread.currentThread().getName());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                output.sendMail2(Thread.currentThread().getName());
            }
        }.start();*/

        new Thread(new Runnable() {
            public void run() {
                output.sendMail(Thread.currentThread().getName());
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                output.sendMail2(Thread.currentThread().getName());
            }
        }).start();
    }

    class Output {
        String lock = "lock";
        /**
         * Description:  重现非唯一资源对象当锁，出现的线程不安全的情况
         *         出现问题的原因是两个线程传入的是不同的对象。
         *         只需要使用 Output 的成员变量 lock 就可以解决。实际是用 this 是更好的。
         * @Author kayle
         * @Data 2016/12/14 18:26
         * @param parames
         * @return void
         */
        public void sendMail(String parames) {
            synchronized (this) {
                try {
                    Thread.sleep(100);
                    for (int i = 0; i < 1000; i++) {
                        System.out.println(i + "---" + parames);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void sendMail2(String parames) {
                try {
                    Thread.sleep(101);
                    for (int i = 0; i < 1000; i++) {

                        System.out.println(i + "---" + parames);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

    }
}
