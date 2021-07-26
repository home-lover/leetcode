package zifuchuanpailie;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description TODO
 * @Date 2021/5/11 10:24 上午
 * @Author Tanjinhong
 */
public class Solution {
    public static List<String> res = new LinkedList<>();
    public static char[] c;

    public static void main(String[] args) {
        System.out.println(permutation("abc"));
        LinkedList<Integer> path = new LinkedList<>();

    }

    public static String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    public static void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }
    public static void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
