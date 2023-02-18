package dp;


/**
 * 63. 不同路径 II
 * https://leetcode.cn/problems/unique-paths-ii/
 * 中等
 * dp
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0,}, {0, 1, 0}, {0, 0, 0}};
        uniquePathsWithObstacles(arr);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }
        return dp[m - 1][n - 1];
    }
}
