package sort;

import java.util.Arrays;

/**
 * 大顶堆排序
 * 从小到大升序排序
 */
public class HeapSort {


    public static void main(String[] args) {

        int[] arr = {1, 10, 3, 8, 5, 6, 7, 4, 9, 2, 9, 2, 7, 4, 5, 6, 3, 8, 1, 10};

//        heapSort(arr);
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    //建堆和调整堆分开,时间复杂度要低,
    public static void heapSort(int[] arr) {
        int size = arr.length;//数组大小
        int index = size / 2 - 1;//指针指向第一个非叶子节点

        //建堆
        while (index >= 0) {//从下到上,开始建堆
            //从第一个非叶子节点
            heap(arr, index, size);
            index--;
        }

        //调整堆
        while (size > 1) {
            //交换堆顶和堆尾
            swap(arr, 0, size - 1);//size-1是索引下标
            size--;
            //调整,从根节点
            heap(arr, 0, size);
        }

    }

    //对index开始往下堆化,只保证index经过的孩子满足大根堆
    public static void heap(int[] arr, int index, int size) {
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
    }


    public static void heapSort_test(int[] arr) {
        //建堆+调整堆,这里直接把建堆和调整堆合成一个函数,复杂度会高
        int size = arr.length;//数组大小
        while (size > 1) {
            //调整堆，第一次调整堆时，就相当于建堆
            heapFromUpToDown(arr, size);
//            heapFromDownToUp(arr, size);

            //交换堆顶和堆尾
            swap(arr, 0, size - 1);//size-1是索引下标
            size--;
        }

    }


    //对数组下[l,r]进行堆化，自下而上，从第一个非叶子节点开始，每一个父节点和其子节点比大小，一直到叶子节点，才开始上一个节点
    public static void heapFromDownToUp(int[] arr, int size) {
        int index = size / 2 - 1;//指针指向第一个非叶子节点
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
        int index = 0;//指针指向根节点
        while (index < size) {
            //当index节点有父节点时,即不是根节点
            while (index != 0) {
                int parentIndex = (index - 1) / 2;//定义当前节点的父节点索引
                //如果父节点最大的，结束当前节点循环
                if (arr[parentIndex] >= arr[index]) break;
                else {
                    swap(arr, index, parentIndex);
                    //从最大索引处往下找
                    index = parentIndex;
                }
            }
            index++;
        }
    }


    //数组交换函数，i,j为交换下标
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
