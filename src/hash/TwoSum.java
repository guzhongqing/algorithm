package hash;

import java.util.HashMap;
import java.util.Map;

//1. 两数之和
// https://leetcode.cn/problems/two-sum/
//map作为哈希表
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {
        //创建一个哈希表
        Map<Integer, Integer> map = new HashMap<>();

        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 在哈希表中找与当前数组的值匹配的值(target-nums[i])，
            if (map.containsKey(target - nums[i])) {
                //若找到，则直接返回这两个值的下标，
                return new int[]{map.get(target - nums[i]), i};
            }
            //若没找到，则把当前值和下标放入哈希表
            map.put(nums[i], i);
        }

        //整个数组都没有，返回一个空数组
        return new int[0];
    }

}
