package solution;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 2357. 使数组中所有元素都等于零
 * https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/
 * 简单
 */
public class MminimumOperations {
    public static void main(String[] args) {
        int[] arr = {1, 5, 0, 3, 5};

        minimumOperations(arr);

    }

    //排序+模拟
    public static int minimumOperations(int[] nums) {
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr != 0) {
                for (int j = i; j < nums.length; j++) {
                    nums[j] -= curr;
                }
//                System.out.println(Arrays.toString(nums));
                cnt++;
            }
        }
        return cnt;
    }

    //哈希，不同非零元素个数
    public static int hash(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }


}
