package com.liukai.thread;

/**
 * TODO
 *
 * @author liu kai
 * @date 2020-06-12 11:41
 */
public class InnerStaticClassTest {

    public static class InnerClass{
        public String NUMBER = "test";

    }
    public static void main(String[] args) {
        InnerStaticClassTest.InnerClass innerClass = new InnerClass();

        InnerStaticClassTest.InnerClass innerClass2 = new InnerStaticClassTest.InnerClass();
        System.out.println(innerClass.NUMBER);
        System.out.println(innerClass2.NUMBER);

    }
}
