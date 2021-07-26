package com.pdd;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2021/7/25 7:05 下午
 * @Author Tanjinhong
 */
public class Main {
    public static void main(String[] args) {
        System.out.print(helper());
    }

    public static String helper() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = scan.nextInt();
            arr2[i] = scan.nextInt();
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr1[i] >= arr1[j] && arr2[i] <= arr2[j]) {
                    return "true";
                }
            }
        }
        return "false";
    }
}
