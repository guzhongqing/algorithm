package dp;

/**
 * 509. 斐波那契数
 * 简单
 * dp，递归
 */
public class Fib {
    //0 1 2 3 4 5 6
    //0 1 1 2 3 5 8

    //dp优化,滚动数组思想
    public int dpOptimize(int n) {
        if (n < 2) return n;
        int a = 0, b = 0, c = 1;
        //从2开始
        for (int i = 2; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;
        }
        return c;
    }


    //dp
    public int fib(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    //递归
    public int fibRecursion(int n) {
        if (n < 2) return n;
        return fib(n - 2) + fib(n - 1);
    }


}
