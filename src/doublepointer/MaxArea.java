package doublepointer;

/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water
 * 中等
 * 双指针
 */
public class MaxArea {
    // 模拟，n2,超时
    public int maxAreaBySimulate(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                max = Math.max(max, minHeight * (j - i));
            }
        }
        return max;
    }

    // 双指针
    public int maxArea(int[] height) {

        return 1;
    }

    public static void main(String[] args) {

        MaxArea obj = new MaxArea();
        int[] inputs = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ans = obj.maxAreaBySimulate(inputs);
        System.out.println(ans);

    }


}
