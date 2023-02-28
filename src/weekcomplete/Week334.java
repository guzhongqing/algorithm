package weekcomplete;

import java.util.Arrays;

/**
 * https://leetcode.cn/contest/weekly-contest-334
 */
public class Week334 {

    public static void main(String[] args) {
        int[] inputArr = {10, 4, 8, 3};
        System.out.println(Arrays.toString(leftRightDifference(inputArr)));

//        int[] inputArr = new int[]{1};
//        System.out.println(Arrays.toString(leftRightDifference(inputArr)));

    }

    /**
     * 6369. 左右元素和的差值
     * https://leetcode.cn/problems/left-and-right-sum-differences/
     */
    public static int[] leftRightDifference(int[] nums) {
        int[] answer = new int[nums.length];
        int leftSum = 0, rightSUm = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
//            System.out.println((leftSum - nums[i]));
            rightSUm -= nums[i];
//            System.out.println(rightSUm);
            answer[i] = (leftSum - nums[i]) > rightSUm ?
                    (leftSum - nums[i]) - rightSUm :
                    rightSUm - (leftSum - nums[i]);
        }
        return answer;
    }


    //先求出nums的sum 然后定义一个变量记录左边的和，右边的和就是sum-左边和-当前元素值
    public int[] leftRigthDifference(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int[] ans = new int[nums.length];
        int temp = 0;//左边和
        for (int i = 0; i < nums.length; i++) {
            ans[i] = Math.abs(sum - temp - nums[i] - temp);
            temp += nums[i];
        }
        return ans;
    }


}


