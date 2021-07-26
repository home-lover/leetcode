package kechengbiao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * @Description TODO
 * @Date 2021/4/26 3:33 下午
 * @Created by tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        int numCourse = 3;
        int[][] prerequisites = {{0,1},{2,1}};


        System.out.println(canFinish(numCourse, prerequisites));

        String a = "a";
        String b = "b";
        String c = "c";

        List<String> res = new ArrayList<>();
        res.add(a);
        res.add(b);
        res.add(c);
        System.out.println(res);

        IntStream.range(0, 3).forEach(i -> {
            System.out.println(i);
        });

         long t1=System.currentTimeMillis();
         List<Integer> list1 = new ArrayList<>();
         for(int i = 0; i < 1000000*100000; i++) {
             list1.add(i);
         }
        long t2=System.currentTimeMillis();

         System.out.println(t2 - t1);


        long t3=System.currentTimeMillis();

        for(int i = 0; i < 1000000*100000; i++) {
            List<Integer> list2 = new ArrayList<>();
        }
        long t4=System.currentTimeMillis();

        System.out.println(t4 - t3);

    }

    public static boolean canFinish(int numCourse, int[][] prerequisites) {
        int[] count = new int[numCourse];
        List<List<Integer>> adjust = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourse; i++) {
            adjust.add(new ArrayList<>());
        }
        for(int[] list : prerequisites) {
            count[list[0]]++;
            adjust.get(list[1]).add(list[0]);
        }
        for(int i = 0; i < numCourse; i++) {
            if(count[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourse--;
            for(int curr : adjust.get(pre)) {
                count[curr]--;
                if(count[curr] == 0) {
                    queue.offer(curr);
                }
            }
        }

        return numCourse == 0;
    }

}
