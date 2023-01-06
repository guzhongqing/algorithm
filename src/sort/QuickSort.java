package sort;

import java.util.Arrays;

//分治思想
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 5, 5, 2, 4, 6, 8, 8};
        quick_sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    //记住此快排算法！！
    //这个算法有点牛逼牛逼，选择二分下标作为基准，也可以是第一个元素
    //指针先行，所以左右指针先往外移动一位
    public static void quick_sort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;

        //因为每次是先移动左右指针，所以要先吧左指针-1，把右指针+1
        int i = leftIndex - 1, j = rightIndex + 1, pivot = arr[leftIndex + rightIndex >> 1];//这里+号优先级大于>>移位运算符
        //这里pivot选择可以是任意的，也可以是arr[leftIndex]

        while (i < j) {
            do i++; while (arr[i] < pivot);
            do j--; while (arr[j] > pivot);//最终i和j指针
            if (i < j) swap(arr, i, j);
        }
        //此时区间[leftIndex,i-1]中的数都小于等于pivot
        //此时区间[j+1,rightIndex]中的数都大于等于pivot

        //在分别对于左右区间进行排序
        quick_sort(arr, leftIndex, i - 1);
        quick_sort(arr, j + 1, rightIndex);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //思路，先判断自己，再移动指针，
    //把与基准相等的元素放到左右递归中，等左右在排序好，自动会排到基准旁边，即基准比自己大也比自己小
    //始终有一个指针指着基准，选择每个分区最左边下标作为基准
    //先判断，指针再动
    public static void select(int[] r, int beginIndex, int endIndex) {
        if (beginIndex < endIndex) {
            int i = beginIndex, j = endIndex, key = r[i];
            while (i < j) {
                while (i < j && r[j] >= key) j--;  //这里取等号
                if (i < j) {
                    r[i] += r[j] - (r[j] = r[i]);//交换r[i],r[j]
                }
                while (i < j && r[i] <= key) i++;  //这里取等号
                if (i < j) {
                    r[i] += r[j] - (r[j] = r[i]);
                }
            }
            select(r, beginIndex, i - 1);
            select(r, i + 1, endIndex);
        }
    }

    //此算法有问题，数组中有相同值，跳不出循环
    public static void quicksort(int[] array, int left, int right) {
        if (left >= right) return;//这里要先判断，防止数组越界
        int i = left, j = right, key = array[i];
        while (i < j) {
            while (i < j && array[j] > key) j--;//右指针向左走
            while (i < j && array[i] < key) i++;//左指针向右走
            if (i < j) array[i] += array[j] - (array[j] = array[i]);//交换array[i]和array[j]
        }
        quicksort(array, left, i - 1);
        quicksort(array, i + 1, right);
    }


}
