package test;


import java.util.Arrays;

class Test {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = new int[10];


        System.arraycopy(a, 1, b, 5, 3);
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(b));
    }

}



