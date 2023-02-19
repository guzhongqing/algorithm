package doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/
 * 中等
 * 双指针
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);//排序
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //排序后第一个大于0则不可能和为0
            if (nums[i] > 0) return ans;
            if (i > 0 && nums[i] == nums[i - 1]) continue;//去重a
            int left = i + 1, right = n - 1;
            for (; left < n; left++) {
                if (left > i + 1 && nums[left] == nums[left - 1]) continue;//去重b
                while (left < right && nums[i] + nums[left] + nums[right] > 0) right--;
                if (left == right) break;
                if (nums[i] + nums[left] + nums[right] == 0) ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
            }
        }
        return ans;
    }


}



