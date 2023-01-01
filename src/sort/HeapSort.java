package sort;

import java.util.Arrays;

/**
 * 大顶堆排序
 * 从小到大升序排序
 */
public class HeapSort {

    private static int[] arr = {1, 3, 5, 5, 2, 2, 4, 6};

    public static void main(String[] args) {
        heapSort(arr);
        System.out.println(Arrays.toString(arr));


    }


    public static void heapSort(int[] arr) {
        //建堆+调整堆
        int size = arr.length;//数组大小
        while (size > 1) {
            int left = 0, right = size - 1;//定义堆首和堆尾索引下标
            //调整堆，第一次调整堆时，就相当于建堆
//            heapFromUpToDown(arr, left, right);
            heapFromDownToUp(arr, left, right);
            //交换堆顶和堆尾
            swap(arr, left, right);//size-1是索引下标
            size--;
        }

    }

    //对数组下[l,r]进行堆化，自上而下
    public static void heapFromUpToDown(int[] arr, int l, int r) {


    }


    //对数组下[l,r]进行堆化，自下而上
    public static void heapFromDownToUp(int[] arr, int l, int r) {
        int rIndex = (r + 1) / 2

                - 1;//右指针指向第一个非叶子节点


    }

    //数组交换函数，i,j为交换下标
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
