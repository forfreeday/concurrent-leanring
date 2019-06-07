package com.liukai.thread.thread_local;

public class TestThread5 {
    public static void main(String[] args) {
		Test t = new Test();
		// 同是执行3条线程，并且让线程睡眠10豪秒，模拟线程不安全的情况。
		Thread thread1 = new Thread(t);
		Thread thread2 = new Thread(t);
		Thread thread3 = new Thread(t);
		Thread thread4 = new Thread(t);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}

class Test implements Runnable {
	int i = 1500;
	boolean flag = true;

	public void run() {
		while (flag) {
			//synchronized(this) {
				show();
			//}
		}
	}

	public /*synchronized*/ void show() {
		try {
			Thread.sleep(10); // 模拟线程不安全的情况
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (i > 0) {
			System.out.println(Thread.currentThread().getName() + "--->" + i--);
		}
	}
}
