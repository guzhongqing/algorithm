package dp;


/**
 * 1664. 生成平衡数组的方案数
 * https://leetcode.cn/problems/ways-to-make-a-fair-array/
 * 中等
 * dp，滚动数组
 */
public class WaysToMakeFair {
    public int waysToMakeFair(int[] nums) {
        int odd2 = 0, even2 = 0;
        int odd1 = 0, even1 = 0;

        //求出奇数偶数位下标和
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) != 0) odd2 += nums[i];//奇数
            else even2 += nums[i];//偶数
        }
        int ans = 0;


        //扫过的even变成odd，扫过的odd变成even
        for (int i = 0; i < nums.length; i++) {
            //遍历删除奇偶下标改变的数
            if ((i & 1) != 0) odd2 -= nums[i];
            else even2 -= nums[i];

            //判断未改变的奇数+变为奇数的偶数是否等于未改变的偶数+变为偶数的奇数
            if (odd2 + even1 == even2 + odd1) ans++;

            //给改变的奇偶数下标求和
            if ((i & 1) != 0) odd1 += nums[i];
            else even1 += nums[i];
        }

        return ans;
    }


}
