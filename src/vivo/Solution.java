package vivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2021/6/16 8:52 下午
 * @Author Tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = "the sky is  blue";
        String[] str1 = s.split(" ");

//        for(String s : str1) {
//            System.out.print(s + ",");
//        }
//        int[] nums = new int[3];
//        int i = 0;
//        while(i< 3) {
//            nums[i] = scan.nextInt();
//            i++;
//        }
//
//        for(int j : nums) {
//            System.out.print(j + ",");
//        }

//        int a1 = scan.nextInt();
//        int a2 = scan.nextInt();
//        int a3 = scan.nextInt();
//        System.out.print(a1 + ",");
//        System.out.print(a2 + ",");
//        System.out.print(a3 + ",");
    }
    public static void test() {
        Scanner scan = new Scanner(System.in);
        int total = Integer.parseInt(scan.nextLine());
        //int total = scan.nextInt();
        String[] str1 = scan.nextLine().split(",");
        String[] str2 = scan.nextLine().split(",");
        int length = str2.length;
        int[] weight = new int[length];
        int[] value = new int[length];
        for(int i = 0; i < length; i++) {
            weight[i] = Integer.parseInt(str1[i]);
            value[i] = Integer.parseInt(str2[i]);
        }

        int[] dp = new int[total + 1];
        dp[0] = 0;
        for(int i = 1; i < length + 1; i++) {
            for(int j = total; j >= weight[i - 1]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
            }
        }
        System.out.println(dp[total]);
    }
}
