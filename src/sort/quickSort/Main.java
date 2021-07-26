package sort.quickSort;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2021/7/7 4:12 下午
 * @Author Tanjinhong
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 1, 23, 5, 16, 8};
        quickSort(arr, 0, arr.length - 1);
        for(int i : arr) {
            System.out.print(i + ",");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        int index = partition(arr, start, end);
        quickSort(arr, start, index - 1);
        quickSort(arr, index + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int temp = arr[start];
        //升序
        while(start < end) {
            //右边找一个比temp小的
            //降序则temp >= arr[end]
            while (start < end && temp <= arr[end]) {
                end--;
            }
            if(start < end) {
                arr[start] = arr[end];
            }
            //左边找一个比temp大的
            //降序则temp <= arr[start]
            while (start < end && temp >= arr[start]) {
                start++;
            }
            if(start < end) {
                arr[end] = arr[start];
            }
        }
        arr[start] = temp;
        return start;
    }

//    public static int find(int[] arr) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(Map.Entry<Integer,Integer> tmp : map.entrySet()) {
//            int k = tmp.getKey();
//        }
//    }
}
