package solution;


import java.util.Arrays;

/**
 * 1819. 序列中不同最大公约数的数目
 * https://leetcode.cn/problems/number-of-different-subsequences-gcds/
 * 困难
 * 数论
 */
public class CountDifferentSubsequenceGCDs {

    public static void main(String[] args) {
        System.out.println(2 % 12);
        System.out.println(gcd(10, 5));

    }


    public int countDifferentSubsequenceGCDs(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt();

        boolean[] occurred = new boolean[maxVal + 1];
        for (int num : nums) {
            occurred[num] = true;
        }
        int ans = 0;
        for (int i = 1; i <= maxVal; i++) {
            int subGcd = 0;
            for (int j = i; j <= maxVal; j += i) {
                if (occurred[j]) {
                    if (subGcd == 0) {
                        subGcd = j;
                    } else {
                        subGcd = gcd(subGcd, j);
                    }
                    if (subGcd == i) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }


    public static int gcd(int a, int b) {
        //判断最大公约数先判断a%b是否除尽，正好除尽最大公约是就是b，没有，就在用gcd(b,a%b)
        return a % b == 0 ? b : gcd(b, a % b);
    }


}
