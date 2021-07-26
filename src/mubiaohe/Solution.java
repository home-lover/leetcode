package mubiaohe;

/**
 * @Description TODO
 * @Date 2021/5/30 3:56 下午
 * @Author Tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 4, 5};
        int s = 7;
        System.out.println(findTargetSumWays(nums, s));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(S > sum || (S + sum) % 2 == 1) {
            return 0;
        }
        int target = (S + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int num : nums){
            for(int j = target; j >= num; j--){
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];
    }

}
