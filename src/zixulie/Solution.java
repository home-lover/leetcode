package zixulie;

public class Solution {
    public static void main(String[] args) {
        String s = "eo";
        //b = b.replace("b", "");
        String t = "helloworld";
        System.out.println(isSubsequence(s, t));
    }
    public static String isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(s.charAt(i) == t.charAt(j)) {
                i++;
                char tmp = s.charAt(i);
                t = t.replace(String.valueOf(tmp), "");
                n = t.length();
            }
            j++;
        }
        return t;
    }
}
