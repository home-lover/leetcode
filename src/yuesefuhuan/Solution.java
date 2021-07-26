package yuesefuhuan;

import java.lang.invoke.LambdaConversionException;

/**
 * @Description TODO
 * @Date 2021/5/6 3:57 下午
 * @Author Tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5, 3));
    }
    public static int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
