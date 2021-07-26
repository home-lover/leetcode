package zhaolingqian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Date 2021/6/16 5:43 下午
 * @Author Tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void helper(List<List<Integer>> res, List<Integer> tmp, int start, int target, int[] coins) {
        if(target == 0) {
            if(res.size() == 0) {
                res.add(new ArrayList<>(tmp));
            }else if(res.get(0).size() > tmp.size()){
                res.remove(res.size() - 1);
                res.add(new ArrayList<>(tmp));
            }
        }else if(target > 0) {
            for(int i = 0; i < coins.length; i++) {
                tmp.add(coins[i]);
                helper(res, tmp, i, target - coins[i], coins);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
