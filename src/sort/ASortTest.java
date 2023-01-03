package sort;

import java.util.Arrays;
import java.util.Random;

//这是一个测试手撕排序算法正确的类
public class ASortTest {

    public static void main(String[] args) {

        int[] a = new int[10];
        int cases = 10000;
        boolean flag = true;
        while (0 != cases--) {
            for (int i = 0; i < a.length; i++) {
                a[i] = new Random().nextInt(99) + 1;
            }
            int[] b = a.clone();
            Arrays.sort(b);


            try {
//            QuickSort.select(a, 0, a.length - 1);
                QuickSort.quicksort(a, 0, a.length);
            } catch (Exception e) {
//                e.printStackTrace();//打印报错
            }

            flag = Arrays.equals(a, b);
            if (!flag) break;
        }
        if (flag) System.out.println("目前算法正确");
        else System.out.println("此算法有问题");


    }


}
