package solution;

import java.util.Arrays;

/**
 * 2335. 装满杯子需要的最短总时长
 * https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/
 * 简单
 * 贪心，数学
 */
public class FillCups {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }

}
