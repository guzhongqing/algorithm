package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Test {
    static Integer a;

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 5, 0};
        Arrays.sort(arr);
        int[][] arr2 = {{1, 2}, {3, 1}, {2, 5}};
        Arrays.sort(arr2, (a, b) -> b[0] - a[0]);

        System.out.println(Arrays.toString(arr2));
    }


    public void fuc() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(0, 1);
        System.out.println(objects.getClass().getName());

        PriorityQueue<Object> objects1 = new PriorityQueue<>();
    }


}




