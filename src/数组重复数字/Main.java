package 数组重复数字;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description TODO
 * @Date 2021/7/8 3:21 下午
 * @Author Tanjinhong
 */
public class Main {
    public static void main(String[] args) {
        int[] a1 = {3, 2, 4, 5, 2};
        int[] a2 = {2, 2, 1, 1, 3};
        int n1 = a1.length, n2 = a2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
            for(int i : a1) {
                if(map.containsKey(i)) {
                    map.put(i,map.get(i)+1);
                }else {
                    map.put(i,1);
                }
            }

            for(int i : a2) {
                if(map.containsKey(i)) {
                    if(map.get(i) > 0) {
                        res.add(i);
                        map.put(i, map.get(i) - 1);
                    }
                }
            }

            System.out.print(res);
    }
}
