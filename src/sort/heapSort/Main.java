package sort.heapSort;

/**
 * @Description TODO
 * @Date 2021/6/7 8:48 下午
 * @Author Tanjinhong
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 4, 1, 6, 9, 4, 8};
        int[] arr1 = {5, 1, 7, 4, 1, 6, 9, 4, 8};
        //int[] arr = {16, 7, 3, 20, 17, 8};

        heapSort(arr);
        Solution.heapSort(arr1);


        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println();
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }

    private static void heapSort(int[] arr) {
        //创建大根堆
        for(int i = (arr.length) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for(int i = arr.length - 1; i > 0; i--) {
            //根结点与最后一个节点交换
            swap(arr, 0, i);
            //交换后再调整堆
            adjustHeap(arr, 0, i);
        }

    }

    private static void adjustHeap(int[] arr, int parent, int length) {
        int temp = arr[parent];
        //2 * n + 1一定是左孩子
        int lChild = parent * 2 + 1;
        while(lChild < length) {
            int rChild = lChild + 1;
            //找到左右孩子中最大的那个
            if(rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }
            //如果父节点最大，则提前返回
            if(temp > arr[lChild]) {
                break;
            }

            arr[parent] = arr[lChild];
            //继续向下 进行堆调整
            parent = lChild;
            lChild = lChild * 2 + 1;
        }

        arr[parent] = temp;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
