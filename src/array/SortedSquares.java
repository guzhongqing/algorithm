package array;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 * 简单
 * 暴力，双指针
 */
public class SortedSquares {


    //暴力
    //时间复杂度：O(nlogn)，其中 n 是数组 nums 的长度。
    //空间复杂度：O(logn)。O(logn) 的栈空间进行排序。
    public int[] baoLi(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }


    //双指针
    //时间复杂度：O(n)，其中 n 是数组 nums 的长度。
    //空间复杂度：O(n)。这里创建一个长度为n的res数组
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n - 1;//定义左右指针
        int resIndex = n - 1;//res数组从右边开始遍历

        //nums数组的平方，两边大，中间小
        while (l <= r) {
            int l2 = nums[l] * nums[l];//nums数组左指针元素的平法
            int r2 = nums[r] * nums[r];//nums数组右指针元素的平法
            if (l2 > r2) {
                res[resIndex--] = l2;
                l++;//左指针右移
            } else {
                res[resIndex--] = r2;
                r--;//右指针左移
            }
        }
        return res;
    }


}
