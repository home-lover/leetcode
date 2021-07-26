package zhengshucimi;

/**
 * @Description TODO
 * @Date 2021/5/10 11:50 上午
 * @Author Tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(myPow(-2.1,-3));
    }
    public static double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) {
            return 1 / (x * myPow(x, - n - 1));
        }else {
            return x * myPow(x, n - 1);
        }
    }
}
