package com.liukai.thread;

public class Outter {
    public static void main(String[] args) {
        InnerClass1 ic1 = new InnerClass1();    // 直接 new 不依赖于外部类的引用
        System.out.println(ic1);
        Outter.InnerClass1.increase();
    }

    static class InnerClass1 {
        private static Integer number = 100;                // 静态变量

        private static Integer increase() {                // 静态方法
            return 0;
        }
    }
}