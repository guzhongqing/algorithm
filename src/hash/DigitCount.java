package hash;

/**
 * 2283. 判断一个数的数字计数是否等于数位的值
 * https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/
 * 简单
 * 数组作为数字哈希表
 */
public class DigitCount {

    public boolean digitCount(String num) {

        int[] map = new int[10];
        char[] nums = num.toCharArray();

        for (char ch : nums) {
            int index = ch - '0';
            map[index]++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - '0' != map[i]) return false;
        }
        return true;
    }
}
