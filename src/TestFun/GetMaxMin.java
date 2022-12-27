package TestFun;

import java.util.Arrays;

public class GetMaxMin {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 4};
        System.out.println(Arrays.stream(arr).max().getAsInt());
        System.out.println(Arrays.stream(arr).min().getAsInt());
        System.out.println(Math.max(2,3));
        System.out.println(Math.min(2,3));

    }

}
