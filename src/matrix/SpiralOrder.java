package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 54.螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix
 * 中等
 * 数组，矩阵，四个点定位
 */
public class SpiralOrder {


    // 按层模拟 时间nm，空间1
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        // 定义四个变量，组成四个顶点坐标[top,left]，[top,right]，[bottom,right]，[bottom,left]
        int top = 0, bottom = matrix.length - 1;// 取到边界值
        int left = 0, right = matrix[0].length - 1;// 取到边界值
        while (true) {
            // top层从左到右
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            // 判断全部遍历完成
            if (++top > bottom) break;

            // right层从上到下
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            // 判断全部遍历完成
            if (--right < left) break;

            // bottom层从右到左
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            // 判断全部遍历完成
            if (--bottom < top) break;

            // left层从下到上
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            // 判断全部遍历完成
            if (++left > right) break;

        }
        return ans;
    }

    public static void main(String[] args) {


        int[][] inputs = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        SpiralOrder spiralOrder = new SpiralOrder();
        List<Integer> ans = spiralOrder.spiralOrder(inputs);
        System.out.println(ans);


    }
}