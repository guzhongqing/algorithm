package sort;

import java.util.Arrays;

/**
 * 大顶堆排序
 * 从小到大升序排序
 */
public class HeapSort {

    private static int[] arr = {1,3,5,7,9,2,4,6,8,10};

    public static void main(String[] args) {
        heapSort(arr);
        System.out.println(Arrays.toString(arr));


    }


    public static void heapSort(int[] arr) {
        //建堆+调整堆
        int size = arr.length;//数组大小
        while (size > 1) {
            //调整堆，第一次调整堆时，就相当于建堆
//            heapFromUpToDown(arr, size);
            heapFromDownToUp(arr, size);

            //交换堆顶和堆尾
            swap(arr, 0, size - 1);//size-1是索引下标
            size--;
        }

    }


    //建议使用次方法
    //对数组下[l,r]进行堆化，自下而上，从第一个非叶子节点开始，每一个父节点和其子节点比大小，一直到叶子节点，才开始上一个节点
    public static void heapFromDownToUp(int[] arr, int size) {

        int index = size / 2 - 1;//右指针指向第一个非叶子节点

        while (index >= 0) {

            //index节点有左孩子时，即有孩子
            while (2 * index + 1 < size) {
                int lChild = 2 * index + 1;//左孩子索引
                int rChild = 2 * index + 2;//右孩子索引

                int maxIndex = lChild;
                //index有右孩子，并且右孩子>左孩子，把最大节点赋值给maxIndex
                if (rChild < size && arr[rChild] > arr[lChild]) maxIndex = rChild;

                //如果当前节点就是最大的，结束当前节点循环
                if (arr[index] >= arr[maxIndex]) break;

                swap(arr, index, maxIndex);
                //从最大索引处往下找
                index = maxIndex;
            }

            index--;
        }

    }

    //对数组下[l,r]进行堆化，自上而下，从根节点开始，每一子个节点和其父节点比大小，一直到根节点，才开始下一个节点
    public static void heapFromUpToDown(int[] arr, int size) {




    }


    //数组交换函数，i,j为交换下标
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
