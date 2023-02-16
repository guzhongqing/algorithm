package hash;

/**
 * 2341. 数组能形成多少数对
 * https://leetcode.cn/problems/maximum-number-of-pairs-in-array/
 * 简单
 * 哈希表
 */
public class NumberOfPairs {

    public int[] numberOfPairs(int[] nums) {
        int[] map = new int[101];//[0,100]
        //遍历nums数组
        for (int num : nums) {
            map[num]++;
        }
        int pair = 0, remain = 0;
        //遍历map数组
        for (int num : map) {
            if (num == 0) continue;
            pair += num / 2;
            //奇数
            if ((num & 1) == 1) remain++;
        }
        return new int[]{pair, remain};
    }

}
