package baidu;

import java.util.Arrays;

/**
 * @Description TODO
 * @Date 2021/7/19 7:50 下午
 * @Author Tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {3, 1, 14, 2, 5, 2};
        int[] res = add(arr, 999);
        for(int i : res) {
            System.out.print(i + ",");
        }
        System.out.println();
        int t = get(res);

        System.out.print(t);
    }

    public static int[] add(int[]arr, int x) {
        int[] res = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }

        res[arr.length] = x;
        Arrays.sort(res);
        return res;
    }

    public static int get(int[] arr) {

        return arr[arr.length / 2];
    }
}
