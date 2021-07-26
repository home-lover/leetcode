package test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2021/6/17 10:58 上午
 * @Author Tanjinhong
 */

public class Solution {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
//
//        System.out.println(count(str));
        //System.out.println(changespaceto20("a  b  c"));
        int[] arr = {1,2,3,1};
        System.out.print(rob(arr));
    }

    public static String changespaceto20 (String str) {
        // write code here
        //String res = str.replaceAll(" ","%20");
        //System.out.println(res);

        //char[] ch = str.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                res.append("%20");
            }else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    public static int count(String str) {
        int count = 0, len = str.length(), res = 0;
        if(len == 0) {
            return res;
        }
        for(int i = len - 1; i >= 0; i--) {
            if(str.charAt(i) == 'b') {
                count++;
            }else {
                res = (res + count) % 1000000007;
                count = count * 2 % 1000000007;
            }
        }

        return res;
    }

    public static int rob(int[] nums) {
        int res = 0, curr = 0, pre = 0;
        for(int num : nums) {
            //dp[n+1] = max(dp[n], dp[n-1]+num)
            res = Math.max(curr, pre + num);
            pre = curr;
            curr = res;
        }

        return res;
    }
}
