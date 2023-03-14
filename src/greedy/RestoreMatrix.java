package greedy;

/**
 * 1605. 给定行和列的和求可行矩阵
 * https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/
 * 中等
 * 贪心
 */
public class RestoreMatrix {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }
}
