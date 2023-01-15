package solution;

/**
 * 2293. 极大极小游戏
 * https://leetcode.cn/problems/min-max-game/
 * 简单
 * 模拟
 */
public class MinMaxGame {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        while (n != 1) {
            int[] newNums = new int[n / 2];
            for (int i = 0; i < newNums.length; i++) {
                if (i % 2 == 0) {
                    newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
                } else {
                    newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
                }
            }
            nums = newNums;
            n /= 2;
        }
        return nums[0];
    }
}
