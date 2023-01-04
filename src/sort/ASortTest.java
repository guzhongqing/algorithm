package sort;

import java.util.Arrays;
import java.util.Random;

//这是一个测试手撕排序算法正确的类
public class ASortTest {

    public static void main(String[] args) {

        int[] a = new int[100];
        int cases = 1000000;//测试样例
        boolean flag;
        for (int j = 1; j <= cases; j++) {


            for (int i = 0; i < a.length; i++) {
                a[i] = new Random().nextInt(1000) - 500;//[-500,500)
            }
            int[] b = a.clone();//这里相当于重新new了一个和a一样的数组,地址和a不同
            int[] testArray = a.clone();


            try {
                Arrays.sort(a);
//                System.out.println(Arrays.toString(a));


                //待测试排序算法
//                HeapSort.heapSort(b);
//                QuickSort.select(b, 0, b.length - 1);
//                QuickSort.quicksort(b, 0, b.length - 1);


//                System.out.println(Arrays.toString(b));

                flag = Arrays.equals(a, b);
                if (!flag) {
                    System.out.println("算法有问题");
                    System.out.println("原始数据如下:");
                    System.out.println(Arrays.toString(testArray));
                    System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("算法异常");
                System.out.println("原始数据如下:");
                System.out.println(Arrays.toString(testArray));
                e.printStackTrace();
                System.exit(0);
            }

            if (j % 1000 == 0) {
                System.out.println("已完成" + j + "个测试样例");
            }
        }

        System.out.println("此算法在" + cases + "个随机测试样例中正确");
    }
}
