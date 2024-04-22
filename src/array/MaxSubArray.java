
package array;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray
 * 中等
 * 数组，动态规划，前缀和，哈希表优化，分治
 */
public class MaxSubArray {

    // 暴力，前缀和优化，时间n2，超时，空间1
    public int maxSubArrayByForPre(int[] nums) {
        // 可能子数组和为负数，ans初始化为全局最小数,或者第一个元素
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int preSum = 0;
            for (int j = i; j < nums.length; j++) {
                preSum += nums[j];
                ans = Math.max(ans, preSum);
            }
        }
        return ans;
    }

    // 前缀和 时间n
    // 由于子数组的元素和等于两个前缀和的差，所以求出 nums 的前缀和。
    public int maxSubArrayByPreSum(int[] nums) {
        int ans = nums[0];
        int preSum = 0;
        int minPreSum = 0;
        for (int num : nums) {
            // 计算当前的前缀和
            preSum += num;
            // 计算当前最大子数组和赋值给ans
            ans = Math.max(ans, preSum - minPreSum);
            // 维护最小前缀和
            minPreSum = Math.min(minPreSum, preSum);
        }
        return ans;
    }

    // dp[i]：表示以 nums[i] 结尾 的 连续 子数组的最大和。
    // 时间n，空间n
    public int maxSubArrayByDP(int[] nums) {
        int ans = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    // 时间n，空间1
    public int maxSubArrayByDPOpt(int[] nums) {
        int ans = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            ans = Math.max(ans, pre);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] inputs = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray maxSubArray = new MaxSubArray();
//        int ans = maxSubArray.maxSubArrayByForPre(inputs);
        int ans = maxSubArray.maxSubArrayByDP(inputs);
        System.out.println(ans);
    }
}
