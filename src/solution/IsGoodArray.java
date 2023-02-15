package solution;

/**
 *1250. 检查「好数组」
 * https://leetcode.cn/problems/check-if-it-is-a-good-array/
 * 困难
 * 数论，gcd
 */
public class IsGoodArray {
    public boolean isGoodArray(int[] nums) {
        int divisor = nums[0];
        for (int num : nums) {
            divisor = gcd(divisor, num);
            if (divisor == 1) {
                break;
            }
        }
        return divisor == 1;
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }
}
