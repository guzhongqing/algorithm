package greedy;

import java.util.Arrays;

/**
 * 1798. 你能构造出连续值的最大数目
 * https://leetcode.cn/problems/maximum-number-of-consecutive-values-you-can-make/
 * 中等
 * 贪心
 */

public class GetMaximumConsecutive {

    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int num : coins) {
            if (res < num) break;
            res += num;
        }
        return res;

    }

}
