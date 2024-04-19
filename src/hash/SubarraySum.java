package hash;

import java.util.HashMap;

/**
 * 560. 和为 K 的子数组
 * https://leetcode.cn/problems/subarray-sum-equals-k
 * 中等
 * 哈希表，前缀和，子串，子数组：子数组是数组中元素的连续非空序列
 * 子串问题可以想到前缀和这个方法
 */
public class SubarraySum {
    // 枚举,时间n3,空间1，超时
    public int subarraySumByFor(int[] nums, int k) {
        int ans = 0;
        // 遍历所有子数组，求和，判断
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                // 求和
                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
//                System.out.println(sum);
                // 判断
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // 枚举+前缀和思想，时间n2,空间1
    // 跟两数之和有点类似，减去目标值，在哈希表里面去找这个数
    public int subarraySumByForPreSum(int[] nums, int k) {
        int ans = 0;
        // 遍历所有子数组，求和，判断
        for (int left = 0; left < nums.length; left++) {
            // 通过前缀和思想求和
            int sum = 0;
            for (int right = left; right < nums.length; right++) {
                sum += nums[right];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }


    // 哈希+前缀和，时间n,空间n
    // 重点是 不关心子数组的构成，只关心前面有没有满足条件的前缀和，每当存在一个这样的前缀和，就代表满足一个子数组和为k
    // 每次遍历，把当前数的前缀和加入和哈希表中
    public int subarraySumByHash(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 初始化前缀和为0的情况
        map.put(0, 1);
        // 初始化当前前缀和
        int pre = 0;
        // 遍历数组，变计算前缀和，判断是否满足要求，前缀和放入哈希表
        for (int n : nums) {
            pre += n;
            // 找pre-k,找到加上次数，找不到默认为0
            ans += map.getOrDefault(pre - k, 0);
            // 计算当前前缀和
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] inputs = {1, 2, 3};
        int k = 3;
        SubarraySum subarraySum = new SubarraySum();
//        int ans = subarraySum.subarraySumByFor(inputs, k);
//        int ans = subarraySum.subarraySumByForPreSum(inputs, k);
        int ans = subarraySum.subarraySumByHash(inputs, k);
        System.out.println(ans);
    }
}
