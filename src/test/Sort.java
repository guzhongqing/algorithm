package test;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
    public static void main(String[] args) {
//        集合List排序Collections.sort();


//引用类型数组排序Arrays.sort();
        Integer[] integers = {1, 3, 5, 7, 9, 2, 4, 6, 8};
        //默认按从小到大排序
        Arrays.sort(integers);
        System.out.println(Arrays.toString(integers));

        //重写compare方法，实现从大到小排序
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(integers));

        Arrays.sort(integers, (o1, o2) -> o2 - o1);//Lambda表达式，方法体为true则交换位置，为false则不交换位置
        System.out.println(Arrays.toString(integers));

//基本类型数组排序
        int[] ints = {1, 3, 5, 7, 9, 2, 4, 6, 8};
        //默认按从小到大排序
        Arrays.sort(ints);
        System.out.println(Arrays.toString(ints));

    }
}
