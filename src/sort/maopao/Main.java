package sort.maopao;

import java.util.Stack;

/**
 * @Description TODO
 * @Date 2021/7/15 6:43 下午
 * @Author Tanjinhong
 */
public class Main {
    public static void main(String[] args) {
//        int[] arr = {3, 4, 1, 2, 5};
//        sort(arr);
//        for(int i : arr) {
//            System.out.print(i + ",");
//        }
        System.out.println(helper("u(love)i"));
        System.out.println(helper1("9999999999999", "22"));
    }

    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = arr.length - 1; j > i; j--) {
                if(arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static String helper(String str) {
        char[] ch = str.toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : ch) {
            if(c == '(') {
                stack.push(sb.toString());
                sb = new StringBuilder();
            }else if(c == ')') {
                sb = new StringBuilder(stack.pop() + sb.reverse());
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String helper1(String a, String b) {
        int x = 0;
        for(int i = 0; i < a.length(); i++) {
            int x1 = a.charAt(i) - '0';
            x = x * 10 + x1;
        }
        int y = 0;
        for(int i = 0; i < b.length(); i++) {
            int y1 = b.charAt(i) - '0';
            y = y * 10 + y1;
        }

        return String.valueOf(x + y);
    }
}
