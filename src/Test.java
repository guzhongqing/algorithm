import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1};
        int[] b = a.clone();
        b[2] = 2;
        a[0] = 0;

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

        boolean flag = Arrays.equals(a, b);

        System.out.println(flag);


    }
}
