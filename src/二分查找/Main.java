package 二分查找;

import java.awt.font.NumericShaper;
import java.lang.annotation.Target;

/**
 * @Description TODO
 * @Date 2021/6/29 5:25 下午
 * @Author Tanjinhong
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] nums1 = {1,2,3,4};
        System.out.println(helper(nums, 2));
        System.out.println(helper(nums, 6));

        System.out.println(helper(nums1, 2));
        System.out.println(helper(nums1, 6));

        long a = 1234567;
        System.out.println(String.format("%,d", a));
    }

    public static int helper(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                System.out.println("找到了！");
                return target;
            }
            if(nums[mid] < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }

        }
        System.out.println("没找到-_-");
        return 0;
    }

    public static int find(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return target;
            }

            if(nums[start] <= nums[mid]) {
                if(nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}
