package chengjizuidazishuzu;

/**
 * @Description TODO
 * @Date 2021/5/16 4:47 下午
 * @Author Tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = Integer.MAX_VALUE;
        if(nums.length < 1) {
            return 0;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = imin;
                imin = imax;
                imax = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}
