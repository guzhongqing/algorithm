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
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            // 计算面积
            int area = Math.min(height[left], height[right]) * (right - left);
            // 全局最大面积
            ans = Math.max(area, ans);
            // 移动最小长度的指针,长度一样，随意，这里默认移动左指针
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        MaxArea obj = new MaxArea();
        int[] inputs = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int ans = obj.maxAreaBySimulate(inputs);
        System.out.println(ans);

    }


}
