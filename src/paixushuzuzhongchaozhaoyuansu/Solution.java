package paixushuzuzhongchaozhaoyuansu;

/**
 * @Description TODO
 * @Date 2021/5/17 5:45 下午
 * @Author Tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        for(int i : searchRange(nums, target)) {
            System.out.println(i);
        }

    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int n = nums.length;
        if(n == 0) {
            return res;
        }
        int left = 0, right = n;
        while(left < right) {
            int mid = (left + right) >> 1;
            if(nums[mid] >= target) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        if(nums[left] != target) {
            return res;
        }

        res[0] = left;
        left = 0;
        right = n - 1;

        while(left < right) {
            int mid = (left + right + 1) >> 1;
            if(nums[mid] <= target) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        res[1] = right;
        return res;
    }
}
