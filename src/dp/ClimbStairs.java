package dp;


/**
 * 70. 爬楼梯
 * https://leetcode.cn/problems/climbing-stairs/
 * 简答
 * dp，递归
 */
public class ClimbStairs {


    //dp优化
    public int dpOptimize(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2, sum = 0;
        for (int i = 2; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }


    //dp
    public int dp(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }


    //d递归
    public int Recursion(int n) {
        if (n <= 2) return n;
        return Recursion(n - 1) + Recursion(n - 2);
    }


}
