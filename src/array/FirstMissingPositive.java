package array;

import java.util.HashSet;

/**
 * 41. 缺失的第一个正数
 * https://leetcode.cn/problems/first-missing-positive
 * 困难(要求时间n,空间1)
 * 数组，哈希表
 */
public class FirstMissingPositive {

    // 暴力+哈希表 时间n，空间n
    public int firstMissingPositiveByFor(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n + 1;
    }

    // 原地哈希，时间n，空间1
    public int firstMissingPositiveByHash(int[] nums) {
        int n = nums.length;
        // 通过负数进行标记，首先把非正数变成不影响结果的正数，如n+1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 把[1,n]的对应的nums[i]-1索引元素变为负数，代表这个索引有了
        // 注意，这个数可能已经被前面给变成负数了，所有要取绝对值
        for (int i = 0; i < n; i++) {
            int num=Math.abs(nums[i]);
            if (num<=n) {
                int index = num - 1;
                nums[index] = -Math.abs(nums[index]);
            }
        }
        // 找第一个正数，代表这个数没有被标记，返回i+1
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 都被标记了，返回n+1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] inputs = {7, 8, 9, 11, 12};
//        int ans = new FirstMissingPositive().firstMissingPositiveByFor(inputs);
        int ans = new FirstMissingPositive().firstMissingPositiveByHash(inputs);
        System.out.println(ans);

    }
}