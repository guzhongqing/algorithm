package weekcomplete;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/biweekly-contest-98/
 */
public class Double98 {

    public static void main(String[] args) {
//        System.out.println(minMaxDifference(11891));
//        System.out.println(minMaxDifference(90));
        int[] arr = {1, 4, 3};
        System.out.println(minimizeSum(arr));
        arr = new int[]{1, 4, 7, 8, 5};
        System.out.println(minimizeSum(arr));
        arr = new int[]{31, 25, 72, 79, 74, 65};
        System.out.println(minimizeSum(arr));
    }

    /**
     * 6359. 替换一个数字后的最大差值
     * https://leetcode.cn/problems/maximum-difference-by-remapping-a-digit/
     * 简单
     *
     * @param num
     * @return
     */
    public static int minMaxDifference(int num) {
        char[] max = String.valueOf(num).toCharArray();
        char[] min = String.valueOf(num).toCharArray();
        char temp = 0;
        for (int i = 0; i < max.length; i++) {
            if (temp == 0 && max[i] != '9') {
                temp = max[i];
                max[i] = '9';
            }
            if (max[i] == temp) max[i] = '9';
        }

        temp = 0;
        for (int i = 0; i < min.length; i++) {
            if (temp == 0 && min[i] != '0') {
                temp = min[i];
                min[i] = '0';
            }
            if (min[i] == temp) min[i] = '0';
        }
        return new Integer(String.valueOf(max)) - new Integer(String.valueOf(min));
    }


    /**
     * 6361. 修改两个元素的最小分数
     * https://leetcode.cn/problems/minimum-score-by-changing-two-elements/
     * 中等
     *
     * @param nums
     * @return
     */
    public static int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
//        int ans = Arrays.stream(
//                new int[]{nums[n - 1] - nums[2],
//                        nums[n - 2] - nums[1],
//                        nums[n - 3] - nums[0]}).min().getAsInt();
        ans = Math.min(ans, nums[n - 1] - nums[2]);
        ans = Math.min(ans, nums[n - 2] - nums[1]);
        ans = Math.min(ans, nums[n - 3] - nums[0]);
        return ans;
    }
}
