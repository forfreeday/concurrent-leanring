package com.liukai.thread.wait.sample1;

/**
 * Created by kayle on 2016/12/16.
 */
public class Test {

    public static void main(String[] args) {
        TestWait testWait = new TestWait();
        testWait.setRunning(true);
        Input input = new Input(testWait);
        Output output = new Output(testWait);
        new Thread(input).start();
        new Thread(output).start();
    }
}
