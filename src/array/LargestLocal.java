package array;

/**
 * 2373. 矩阵中的局部最大值
 * https://leetcode.cn/problems/largest-local-values-in-a-matrix/
 * 简单
 * 遍历
 */
public class LargestLocal {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                for (int gi = i; gi < i + 3; gi++) {
                    for (int gj = j; gj < j + 3; gj++) {
                        ans[i][j] = Math.max(ans[i][j], grid[gi][gj]);
                    }
                }
            }
        }
        return ans;
    }
}
