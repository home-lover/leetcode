package quanpailie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Date 2021/6/15 3:51 下午
 * @Author Tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        String s = "abc";
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        System.out.println(permute(nums));
        List<String> ans = new ArrayList<>();
        for(List<Character> list : permute1(cs)) {
            StringBuilder stringBuilder = new StringBuilder();
            for(Character c : list) {
                stringBuilder.append(c);
            }
            ans.add(stringBuilder.toString());
        }
        System.out.println(ans);

        String str1="aac";
        String a1 = str1.substring(0, str1.length() - 1);

        //System.out.println(a1); //左边0位置开始，向右取3个字符  输出：Chi
        String str="abc";
        System.out.println(Solution2.Permutation(str));//从右边开始取3-1个字符    输出：na
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) {
            return res;
        }
        //Arrays.sort(nums);
        helper(nums, new boolean[nums.length], res, new ArrayList<>());

        return res;
    }
    public static List<List<Character>> permute1(char[] nums) {
        List<List<Character>> res = new ArrayList<>();
        if(nums.length == 0) {
            return res;
        }
        //Arrays.sort(nums);
        helper1(nums, new boolean[nums.length], res, new ArrayList<>());


        return res;
    }

    public static void helper(int[] nums, boolean[] visited, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if(tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            //return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }
            //接下来，如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了。
            // if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == true) {
            //     break;
            // }
            visited[i] = true;
            tmp.add(nums[i]);
            helper(nums, visited, res, tmp);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
    public static void helper1(char[] nums, boolean[] visited, List<List<Character>> res, ArrayList<Character> tmp) {
        if(tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            //return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }
            //接下来，如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了。
             if(i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == true) {
                 break;
             }
            visited[i] = true;
            tmp.add(nums[i]);
            helper1(nums, visited, res, tmp);
            tmp.remove(tmp.size() - 1);
            visited[i] = false;
        }
    }
}
