package doublepointer;

/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water
 * 困难
 * 双指针，动态规划
 */
public class Trap {

    // 双指针，对于动态规划的优化
    // 时间n，空间1
    public int trapByDoublePointer(int[] height) {
        int left = 0, right = height.length - 1;
        int preMax = 0, sufMax = 0;
        int ans = 0;
        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if (height[left] < height[right]) {
                ans += preMax - height[left];
                left++;
            } else {
                ans += sufMax - height[right];
                right--;
            }
        }
        return ans;
    }


    // 动态规划前缀最大，后缀最大数组
    // 时间n，空间n
    public int trapByPreSuf(int[] height) {
        int n = height.length;

        // 从前往后找前缀最大值
        int[] preMax = new int[n];
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            // 当前height和之前最大前缀比较
            preMax[i] = Math.max(height[i], preMax[i - 1]);
        }
//        System.out.println(Arrays.toString(preMax));

        // 从后往前找后缀最大值
        int[] sufMax = new int[n];
        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // 当前height和之前最大后缀比较
            sufMax[i] = Math.max(height[i], sufMax[i + 1]);
        }
//        System.out.println(Arrays.toString(sufMax));

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] inputs = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Trap trap = new Trap();
//        int ans = trap.trapByPreSuf(inputs);
        int ans = trap.trapByDoublePointer(inputs);
        System.out.println(ans);
    }

}
