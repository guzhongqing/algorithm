package slidingwindow;

import java.util.Arrays;

/**
 * 1658. 将 x 减到 0 的最小操作数
 * https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/
 * 中等
 * <p>
 * 滑动窗口（双指针之间的窗口大小固定）
 */
public class MinOperations {

    public int minOperations(int[] nums, int x) {

        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if (sum < x) return -1;//如果这个数组的和都小于x，代表数组和不可能让x减到0

        int left = -1, right = 0;//初始化左右指针，左指针指向空前缀，右指针指向数组的一个元素，代表后缀为整个数组
        int lsum = 0, rsum = sum;  //初始化前缀和，后缀和
        int ans = n + 1;


        //遍历left
        for (; left < n; left++) {
            //先判断left是否为初始状态，
            //不为初始状态时，前缀和每次都加上左指针所在元素
            if (left != -1) lsum += nums[left];

            //循环遍历right,right往右走，rsum减小
            while (right < n && lsum + rsum > x) rsum -= nums[right++];

            if (lsum + rsum == x) ans = Math.min(ans, (left + 1) + (n - right));
        }
        return ans > n ? -1 : ans;
    }
}
