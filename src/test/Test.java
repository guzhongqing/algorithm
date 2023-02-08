package test;

import java.util.Arrays;

class Test {


    public static void main(String[] args) {
        String[] strings = "/a".split("/");
        System.out.println(Arrays.toString(strings));//[, a]
        strings = "/a/".split("/");
        System.out.println(Arrays.toString(strings));//[, a]
    }


}


