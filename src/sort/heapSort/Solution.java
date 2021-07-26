package sort.heapSort;

/**
 * @Description TODO
 * @Date 2021/7/7 3:11 下午
 * @Author Tanjinhong
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 4, 1, 6, 9, 4, 8};
        heapSort(arr);
        for(int i: arr) {
            System.out.print(i + ",");
        }
    }

    public static void heapSort(int[] arr) {
        for(int i = arr.length / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for(int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int lChild = parent * 2 + 1;

        while(lChild < length) {
            int rChild = lChild + 1;
            if(rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            if(temp > arr[lChild]) {
                break;
            }

            arr[parent] = arr[lChild];
            parent = lChild;
            lChild = lChild * 2 + 1;
        }

        arr[parent] = temp;
    }

    public static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
