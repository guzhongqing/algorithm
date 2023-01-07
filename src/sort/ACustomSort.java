package sort;

import java.util.Arrays;

public class ACustomSort {


    public static void main(String[] args) {


        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple", "abcedf", "cabcde", "b", "c"};


        //如果定义了比较，默认的比较器就不再使用，也就是只根据当前数组和定义的比较器，进行排序
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        System.out.println(Arrays.toString(words));

        //默认按字典序排序，默认升序
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));


        //字典序降序
        Arrays.sort(words, (a, b) -> b.compareTo(a));
        System.out.println(Arrays.toString(words));


        //自定义字符串数组排序
        // 排序的规则是首先按照单词的长度升序排序，如果单词的长度相同则按照字典序降序排序
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return b.compareTo(a);//字典序降序
            }
        });

        System.out.println(Arrays.toString(words));


        //如果定义了比较，默认的比较器就不再使用，也就是只根据当前数组和定义的比较器，进行排序
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        System.out.println(Arrays.toString(words));

    }

}


