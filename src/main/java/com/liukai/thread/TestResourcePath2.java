package com.liukai.thread;

import java.io.File;
import java.io.IOException;

/**
 * Created by kayle on 2016/12/1.
 */
public class TestResourcePath2 {
    public static void main(String[] args) throws IOException {

        File file = new File("/");      //磁盘根目录 linux: /    windows: 项目所在盘的根如 C:\ D:\
        System.out.println(file.getCanonicalPath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());

        File file2 = new File("");      //项目所在目录  D:\my_workspaces\java_practise

        System.out.println(file2.getCanonicalPath());

        File file3 = new File("java_se");       //D:\my_workspaces\java_practise\java_se
        System.out.println(file3.getCanonicalPath());
        System.out.println(file3.getAbsoluteFile());
        System.out.println(file3.getAbsolutePath());
        System.out.println(file3.getCanonicalFile());

        System.out.println(TestResourcePath2.class.getClassLoader().getResource(""));
        System.out.println(System.getProperty("user.dir"));

        System.out.println(TestResourcePath2.class.getResource(""));

        System.out.println(TestResourcePath2.class.getResource(""));

    }
}
