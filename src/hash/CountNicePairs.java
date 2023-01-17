package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814. 统计一个数组中好对子的数目
 * https://leetcode.cn/problems/count-nice-pairs-in-an-array/
 * 中等
 * hash
 */
public class CountNicePairs {
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        int res = 0;
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int i : nums) {
            int temp = i, j = 0;
            while (temp > 0) {
                j = j * 10 + temp % 10;
                temp /= 10;
            }
            res = (res + h.getOrDefault(i - j, 0)) % MOD;
            h.put(i - j, h.getOrDefault(i - j, 0) + 1);
        }
        return res;
    }
}
