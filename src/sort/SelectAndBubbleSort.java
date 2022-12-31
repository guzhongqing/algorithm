package sort;

import java.util.Arrays;

public class SelectAndBubbleSort {
    //冒泡，改写版
    public static void bubbleMaxToMin(int[] a) {
        for (int i = 1; i < a.length; i++) {//比较a.length-1次
            for (int j = 0; j < a.length - i; j++) {//j是数组下标
                if (a[j] < a[j + 1]) {
                    a[j] += a[j + 1] - (a[j + 1] = a[j]);//比较，小于则交换
                }
            }
        }
    }

    //冒泡
    public static void bubbleMinToMax(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {//这里是比较的次数，不是遍历数组下标，
            for (int j = 0; j < a.length - i - 1; j++) {//每一轮对前a.length-i-1个数进行比较
                if (a[j] > a[j + 1]) {//如果前一个>后一个，则交换，一轮下来，数组的a.length-i-1位为最大的数。
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
    }

    //选择，从前往后遍历
    public static void selectMinToMax(int[] b) {
        for (int i = 0; i < b.length - 1; i++) {//这里i作为下标
            int minIndex = i;
            for (int j = i + 1; j < b.length; j++) {
                if (b[j] < b[minIndex]) {//比较，当前最小元素下标
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int t = b[minIndex];
                b[minIndex] = b[i];
                b[i] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 3, 5, 7, 7, 2, 4, 4, 6, 8, 8};
        bubbleMinToMax(a);
        System.out.println(Arrays.toString(a));

        bubbleMaxToMin(a);
        System.out.println(Arrays.toString(a));

        selectMinToMax(a);
        System.out.println(Arrays.toString(a));
    }
}
