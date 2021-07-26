package shuzuzhongweishu;

import java.util.Arrays;

/**
 * @Description TODO
 * @Date 2021/5/14 11:55 上午
 * @Author Tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        int[] num1 = {1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(num1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int n = len1 + len2;
        int[] res = new int[len1 + len2];
        for(int i = 0; i < len1+len2; i++) {
            if(i < len1) {
                res[i] = nums1[i];
            }else {
                res[i] = nums2[i - len1];
            }
        }

        Arrays.sort(res);
        if(n % 2 == 0) {
            return (res[n/2] + res[(n/2)-1]) / 2.0;
        }else {
            return res[n/2];
        }
    }
}
