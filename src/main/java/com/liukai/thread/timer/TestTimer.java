package com.liukai.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by kayle on 2016/12/13.
 */
public class TestTimer {


    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("aaaaa");
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask, 3000, 2000);  //任务，启动时间，间隔时间
    }
}
