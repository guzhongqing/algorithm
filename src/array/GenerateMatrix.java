package array;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * https://leetcode.cn/problems/spiral-matrix-ii/
 * 中等
 * 数组，方向模拟
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        int[][] ans = generateMatrix(3);
        System.out.println(Arrays.deepToString(ans));
    }

    public static int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int curNum = 1;//当前数字，从1开始
        int maxNum = n * n;//数组最大数字

        int curRow = 0;//定义行索引
        int curColumn = 0;//定义列索引

        //右下为+，左上为-
        int[] dr = {0, 1, 0, -1};//行方向
        int[] dc = {1, 0, -1, 0};//列方向
        int dIndex = 0;//定义方向索引，0右，1下，2左，3上

        while (curNum <= maxNum) {
            ans[curRow][curColumn] = curNum;
            curNum++;

            //定义临时下一个位置
            int nextRow = curRow + dr[dIndex];
            int nextColumn = curColumn + dc[dIndex];
            //判断矩阵界限和下一个数是否为0，为0则代表没有被搜索过
            //行列索引<=n
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || ans[nextRow][nextColumn] != 0) {
                dIndex = (dIndex + 1) % 4;//这里不需要循环，因为会顺时针转到下一个正确的位置
            }
            curRow += dr[dIndex];
            curColumn += dc[dIndex];

        }
        return ans;
    }
}
