package greedy;

/**
 * 1144. 递减元素使数组呈锯齿状
 * https://leetcode.cn/problems/decrease-elements-to-make-array-zigzag/
 * 中等
 * 贪心+分类讨论
 */
public class MovesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        //返回两种情况的最小操作次数
        return Math.min(count(nums, 0), count(nums, 1));

    }

    //从0开始，让奇数位不变，从1开始，让偶数位不变
    public int count(int[] nums, int begin) {
        int cnt = 0;
        //一次走2个数，保证每一位都是都是偶数位或者奇数位
        for (int i = begin; i < nums.length; i += 2) {
            int temp = 0;
            //判断前一位索引
            if (i - 1 >= 0) {
                //求前一个和当前的需要操作最少的次数
                temp = Math.max(temp, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                //求后一个和当前的需要操作最少的次数
                temp = Math.max(temp, nums[i] - nums[i + 1] + 1);
            }
            //最后计算结果
            cnt += temp;
        }
        return cnt;
    }
}

