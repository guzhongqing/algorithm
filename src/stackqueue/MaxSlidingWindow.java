package stackqueue;

import java.util.Arrays;

/**
 * 239. 滑动窗口最大值
 * https://leetcode.cn/problems/sliding-window-maximum/
 * 困难
 * 剪枝,优先队列(基于堆)，双端队列(单调队列)
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ans = optimize(arr, 3);
        System.out.println(Arrays.toString(ans));

        arr = new int[]{1};
        ans = maxSlidingWindow(arr, 1);
        System.out.println(Arrays.toString(ans));
    }

    //暴力，时间n*k，超时，leetcode会自动停止程序，
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];//返回数组
        int l = 0, r = k - 1;
        while (r <= n - 1) {
            ans[l] = getMax(nums, l, r);
            l++;
            r++;
        }
        return ans;
    }

    public static int getMax(int[] arr, int l, int r) {
        int max = Integer.MIN_VALUE;
        while (l <= r) {
            if (arr[l] > max) max = arr[l];
            l++;
        }
        return max;
    }


    //暴力模拟+剪枝,技巧性太强，不推荐
    public static int[] optimize(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = k - 1;
        int pre = -1;// 当前的最大值的下标,如果有相同的最大值，一定指向的是窗口最靠右的值
        int max = Integer.MIN_VALUE; // Integer.MIN_VALUE-1=Integer.MAX_VALUE
        int[] ans = new int[n - k + 1];

        while (right <= n - 1) {
            if (left <= pre) {// 绝大多数情况，剪枝
                // 窗口滑动前的最大值，还在窗口里面
                // 比较上一轮最大值(pre指针所指)和窗口新增的值(right指针所指)
                if (nums[right] >= nums[pre]) {
                    max = nums[right];
                    pre = right;
                }
            } else if (nums[right] >= max - 1) {//剪枝，且一定先右后左
                //第一次时，max-1是Integer.MIN_VALUE-1=Integer.MAX_VALUE
                //max-1是因为max是right-left中最大的，如果有相同的他肯定是最后一个
                //所以这个数后面的数如果不是最大值，那么肯定<=max-1
                max = nums[right];
                pre = right;
            } else if (nums[left] >= max - 1) {//剪枝
                max = nums[left];
                pre = left;
            } else {
                //既不是最左边又不是最右边，就需要手动求最大值
                max = Integer.MIN_VALUE;
                // 求当前窗口的最大值
                for (int i = left; i <= right; i++) {
                    if (nums[i] >= max) {
                        max = nums[i];
                        pre = i;
                    }
                }
                System.out.println("aaa");

            }

            ans[left] = max;
            left++;
            right++;

        }
        return ans;
    }


}