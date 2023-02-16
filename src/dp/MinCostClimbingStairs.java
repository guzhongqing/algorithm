package dp;

/**
 * 746. 使用最小花费爬楼梯
 * https://leetcode.cn/problems/min-cost-climbing-stairs/
 * 简单
 * dp
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] arr = {10, 15, 20};
        minCostClimbingStairs(arr);
        arr = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        minCostClimbingStairs(arr);
    }

    //滚动数组
    public static int dpOptimize(int[] cost) {
        int prev = 0;//dp[0]
        int curr = 0;//dp[1]
        //i代表下标，dp[0]和dp[1]的下标已经初始化
        //遍历dp数组
        for (int i = 2; i <= cost.length; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);//dp[2]
            //移动
            prev = curr;
            curr = next;
        }
        return curr;
    }


    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];//dp比cost多以的顶层
        //递推公式
        //dp[i]=min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        //dp[0],dp[1]是所有递推公式的基础，dp[0] = 0;dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
