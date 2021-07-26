package quanpailie;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description TODO
 * @Date 2021/7/12 11:21 上午
 * @Author Tanjinhong
 */
public class Solution2 {
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if(str == null || str.equals("")) {
            return res;
        }
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        exchange(new boolean[ch.length], ch, res, new StringBuilder(""));
        return res;
    }
    public static void exchange(boolean[] visited, char [] ch, ArrayList<String> res, StringBuilder str){
        if(str.length() == ch.length) {
            res.add(new String(str));
        }
        for(int i = 0; i < ch.length; i++) {
            if(visited[i]) {
                continue;
            }
            if(i > 0 && visited[i - 1] == true && ch[i] == ch[i - 1]) {
                break;
            }
            visited[i] = true;
            str.append(ch[i]);
            exchange(visited, ch, res, str);
            str.deleteCharAt(str.length() - 1);

            visited[i] = false;
        }

    }
}
