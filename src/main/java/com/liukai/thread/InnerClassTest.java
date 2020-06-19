package com.liukai.thread;

/**
 * TODO
 *
 * @author liu kai
 * @date 2020-06-12 11:41
 */
public class InnerClassTest {

    public class InnerClass{
        public String NUMBER = "test";

    }
    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();
        InnerClass in = innerClassTest.new InnerClass();
        System.out.println(in.NUMBER);
    }
}
