package sort.heapSort;

/**
 * @Description TODO
 * @Date 2021/7/18 6:45 下午
 * @Author Tanjinhong
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 1, 7, 77, 3, 5,8};
        sort(arr);
        for(int i : arr) {
            System.out.print(i + ",");
        }
    }
    public static void sort(int[] nums) {
        for(int i = nums.length / 2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    public static void adjustHeap(int[] nums, int parent, int length) {
        int temp = nums[parent];
        int lChild = parent * 2 + 1;
        while(lChild < length) {
            int rChild = lChild + 1;
            if(rChild < length && nums[lChild] < nums[rChild]) {
                lChild++;
            }
            if(temp > nums[lChild]) {
                break;
            }

            nums[parent] = nums[lChild];
            parent = lChild;
            lChild = lChild * 2 + 1;
        }

        nums[parent] = temp;
    }

    public static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
