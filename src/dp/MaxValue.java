package dp;

/**
 * 剑指 Offer 47. 礼物的最大价值
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 中等
 * dp
 */
public class MaxValue {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        maxValue(grid);
    }

    public static int maxValue(int[][] grid) {
        //定义记录到每一个格子最大价值的数组
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        //初始化dp[0][0]
        dp[0][0] = grid[0][0];

        //初始化第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        //初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
//        System.out.println(Arrays.deepToString(dp));

        //递推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[m - 1][n - 1];
    }


    //优化
    public int optimize(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[2][n];
        for (int i = 0; i < m; ++i) {
            int pos = i % 2;
            for (int j = 0; j < n; ++j) {
                f[pos][j] = 0;
                if (i > 0) {
                    f[pos][j] = Math.max(f[pos][j], f[1 - pos][j]);
                }
                if (j > 0) {
                    f[pos][j] = Math.max(f[pos][j], f[pos][j - 1]);
                }
                f[pos][j] += grid[i][j];
            }
        }
        return f[(m - 1) % 2][n - 1];
    }

}
