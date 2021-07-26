package com.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description TODO
 * @Date 2021/7/21 7:05 下午
 * @Author Tanjinhong
 * 有n个车站，k个乘客，每个乘客有出发时间，上车点和下车点
 */
public class Main {
    public static void main(String[] args) {
        System.out.print(helper());
    }

    public static int helper() {
        Scanner scan = new Scanner(System.in);
        int stations = scan.nextInt();
        int passengers = scan.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < passengers; i++) {
            int startTime = scan.nextInt();
            int from = scan.nextInt();
            int to = scan.nextInt();
            if(from > to) {
               int temp = from;
               from = to;
               to = temp;
            }
            int d = Math.min(to - from, stations - to + from);
            //int n = 4;
            for(int j = 0; j < d; j++) {
                for(int n = 0; n < 5; n++) {
                    map.put(startTime + j * 5 + n, map.getOrDefault(startTime + j * 5 + n, 0) + 1);
                }
//                map.put(startTime + j * 5, map.getOrDefault(startTime + j * 5, 0) + 1);
//                map.put(startTime + j * 5 + 1, map.getOrDefault(startTime + j * 5 + 1, 0) + 1);
//                map.put(startTime + j * 5 + 2, map.getOrDefault(startTime + j * 5 + 2, 0) + 1);
//                map.put(startTime + j * 5 + 3, map.getOrDefault(startTime + j * 5 + 3, 0) + 1);
//                map.put(startTime + j * 5 + 4, map.getOrDefault(startTime + j * 5 + 4, 0) + 1);
            }
        }
        int result = -1;
        for(int key : map.values()) {
            result = Math.max(result, key);
        }
        return result;
    }

}
