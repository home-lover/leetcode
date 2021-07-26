package sort.归并;

/**
 * @Description TODO
 * @Date 2021/7/18 6:20 下午
 * @Author Tanjinhong
 */
public class Solution2 {
    //练习数组归并
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 1, 10, 7};

        int[] res = sort(arr, 0, arr.length - 1);
        for(int i : res) {
            System.out.print(i + ",");
        }
    }

    public static int[] sort(int[] a, int start, int end) {
        //二路归并
        int mid = (end + start) / 2;
        if(start < end) {
            sort(a, start, mid);
            sort(a, mid + 1, end);
            merge(a, start, mid, end);
        }
        return a;
    }

    public static void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1;
        int k = 0;

        while(i <= mid && j <= end) {
            if(a[i] < a[j]) {
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }

        while(i <= mid) {
            temp[k++] = a[i++];
        }

        while(j <= end) {
            temp[k++] = a[j++];
        }

        for(int n = 0; n < temp.length; n++) {
            a[start + n] = temp[n];
        }
    }
}
