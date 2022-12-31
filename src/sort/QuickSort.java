package sort;

import java.util.Arrays;
import java.util.Random;

//分治思想
public class QuickSort {
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

    //记住此快排算法！！
    //思路，先判断自己，再移动指针，
    //把与基准相等的元素放到左右递归中，等左右在排序好，自动会排到基准旁边，即基准比自己大也比自己小
    //始终有一个指针指着基准
    static void select(int[] r, int first, int end) {
        if (first < end) {
            int i = first, j = end, key = r[i];
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
            select(r, first, i - 1);
            select(r, i + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        int times = 10000;
        while (0 != times--) {
            for (int i = 0; i < array.length; i++) {
                array[i] = new Random().nextInt(99) + 1;
            }
            System.out.println(Arrays.toString(array));

            //数组是传址引用，传入数组，可以改变数组
            select(array, 0, array.length - 1);

            System.out.println(Arrays.toString(array));
            System.out.println(times);
            System.out.println();
        }
    }
}
