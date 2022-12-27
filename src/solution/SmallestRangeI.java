package solution;

import java.util.Arrays;

//https://leetcode-cn.com/problems/smallest-range-i/
public class SmallestRangeI {
    public static int smallestRangeI(int[] nums, int k) {
        return Math.max(0, Arrays.stream(nums).max().getAsInt() - Arrays.stream(nums).min().getAsInt() - 2 * k);
    }
}
