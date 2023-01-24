package solution;

/**
 * 1828. 统计一个圆中点的数目
 * https://leetcode.cn/problems/queries-on-number-of-points-inside-a-circle/
 * 中等
 * 数论，圆的方程，模拟
 * PS:其实挺简单
 */
public class CountPoints {

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int cnt = 0;
            int x = query[0], y = query[1], r = query[2];
            for (int[] point : points) {
                int px = point[0], py = point[1];
                if (Math.pow(px - x, 2) + Math.pow(py - y, 2) - r * r <= 0) cnt++;
            }
            ans[index++] = cnt;
        }
        return ans;
    }
}
