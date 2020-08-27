package com.liukai.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liukai
 * @since 2020/7/6 18:08.
 */
public class Test {

    public static void main2(String[] args) {
        int sum = 0;
        int n = 100;
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = i; k <= n; k++) {

                }
            }
        }
        System.out.println(sum);
    }

    public static void main1(String[] args) {
        int sum = 0;
        int n = 100;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                sum += i;
                System.out.println("i: " + i + ", j: " + j + ", sum: " + sum);
            }
        }
        System.out.println(sum);
    }

    public static void main4(String[] args) {
        int sum = 0;
        int n = 100;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
    }


//    public static void main(String[] args) {
////        int x = 0, n = 100;
////        for (int i = 1; i <= n; i++) {
////            for (int j = 1; j <= n; j++) {
////                for (int k = 1; k <= n; k++) {
////                    x++;
////                }
////            }
////        }
////        System.out.println(x);
//
//        int i=1,n=100;
//        while(i<n){
//            i = i*2;
//            System.out.println(i);
//        }
//
//    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(2));
        String value = "aaaaaaaa";
//        mapTest(1);
        System.out.println(value.hashCode());
        System.out.println(value.hashCode() >>> 16);
        System.out.println(value.hashCode() ^ (value.hashCode() >>> 16));
        System.out.println(Integer.toBinaryString(312021529));
//        System.out.println(hash(value));
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private static void show(int i) {
        for (int j = 0; j < i; i++) {
            System.out.println(i);
        }
    }

    public int search(int num) {
        int[] arr = {11, 10, 8, 9, 7, 22, 23, 0};
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void mapTest(int num) {
        String value = "aaaaaaaa";
        String value2 = "aaaaaaaaaaaaaaaaa";
        HashMap<String, String> aa = new HashMap<>();

        aa.put("asdf", "");
//        String asdf = aa.get("asdf");

        System.out.println(value.hashCode());
        System.out.println(value2.hashCode());
        int i = -520054487;
        System.out.println(63 & i);

        System.out.println(Integer.toBinaryString(312017024));
        System.out.println(Integer.toBinaryString(value.hashCode()));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));

        System.out.println(Integer.valueOf("00000000000000000001001010011001", 2).toString());

    }
}
