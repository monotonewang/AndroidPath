package com.javapath.array;

import java.util.Scanner;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2017/1/4 16:49 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class TestArray {
    @org.junit.Test
    public void getNums() {
        int[] arr = {5, 89, 94, 12, 17};

        for (int i = 0; i < arr.length; i++) {
            for (int y = i + 1; y < arr.length; y++) {
                for (int t = 0; t < arr.length; t++) {
                    if (arr[i] + arr[y] == arr[t]) {
//					System.out.println("a1=" + a1);
                        System.out.println("x1=" + arr[i] + "----x2=" + arr[y] + "----和=" + arr[t]);
//						return;
                    }
                }

            }
        }
    }

//    @org.junit.Test
//    public  void ArrayTest1() {
//        Scanner scanner = new Scanner(System.in);
//        int a1 = scanner.nextInt();
//        int[] arr = {5, 89, 121, 12, 17};
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int y = i+1; y < arr.length; y++) {
//                if (arr[i] + arr[y] == a1) {
////					System.out.println("a1=" + a1);
//                    System.out.println("x1=" + arr[i] + "x2=" + arr[y]);
//                    return;
//                }
//            }
//        }
//    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int[] arr = {5, 89, 121, 12, 17};

        for (int i = 0; i < arr.length; i++) {
            for (int y = i+1; y < arr.length; y++) {
                if (arr[i] + arr[y] == a1) {
//					System.out.println("a1=" + a1);
                    System.out.println("x1=" + arr[i] + "x2=" + arr[y]);
                    return;
                }
            }
        }
    }
}
