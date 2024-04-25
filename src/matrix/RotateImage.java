package matrix;

/**
 * 48. 旋转图像
 * https://leetcode.cn/problems/rotate-image
 * 中等
 * 数组，矩阵，翻转
 */
public class RotateImage {
    // 水平翻转+主对角线翻转=顺时针90旋转

    // 原地翻转，时间n2，空间1
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 水平翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }

        // 主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    // 新建一个数组，时间n2，空间n2
    public void rotateByNew(int[][] matrix) {
        int n = matrix.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(ans[i], 0, matrix[i], 0, n);
        }
//        System.out.println(Arrays.deepToString(matrix));
    }


    public static void main(String[] args) {
        int[][] inputs = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        RotateImage rotate = new RotateImage();
        rotate.rotateByNew(inputs);


    }
}