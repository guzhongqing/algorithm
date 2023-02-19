package slidingwindow;

import java.util.Arrays;

/**
 * 209. 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/
 * 中等
 * 暴力，前缀和+二分查找，滑动窗口
 */
public class MinSubArrayLen {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 8};
        int ans = Arrays.binarySearch(arr, 7);
        System.out.println(ans);
    }

    //暴力,超时，时间n2，空间1
    public int baoLi(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j + 1 - i);//j+1-i是两个之间的长度
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    //滑动窗口,时间n，空间1
    public int window(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            //如果窗口中的数已经满足target
            while (sum >= target) {
                //先记录当前满足条件的窗口元素长度
                ans = Math.min(ans, end + 1 - start);
                //然后窗口中删除前面的数，并移动起始指针，知道窗口中数的和<target，
                sum -= nums[start++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    //Arrays.binarysearch()，时间logn
    //必须排序，不然会出错，且有不能有多个相同元素
    //如果有目标元素，则返回目标元素下标，
    //如果没有目标元素，则返回目标元素应该出现的索引的负数-1
    //如，0，1，2，5，找目标元素4，则返回-3-1，3索引是目标元素4应该出现的位置

    //前缀和+二分查找，时间nlogn，空间n
    public int binary(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;
        int[] sums = new int[n + 1];//定义前缀和数组
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推

        //初始化nums,前缀和数组是从小到大排序的，前缀包括尾元素
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        //遍历sums数组,i类似于起始指针
        for (int i = 1; i <= n; i++) {
            int bound = Arrays.binarySearch(sums, sums[i - 1] + target);
            //查不到正好的数，则反向找到应该位置的索引
            if (bound < 0) bound = -bound - 1;
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


}
