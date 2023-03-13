package solution;

import java.util.Arrays;

/**
 * 2383. 赢得比赛需要的最少训练时长
 * https://leetcode.cn/problems/minimum-hours-of-training-to-win-a-competition/
 * 简单
 * 模拟
 */
public class MinNumberOfHours {

    public static void main(String[] args) {
        int[] energy = {1, 1, 1, 1};
        int[] experience = {1, 1, 1, 50};
        minNumberOfHours(1, 1, energy, experience);
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        // 精力>精力和
        int sum = Arrays.stream(energy).sum();
        ans += Math.max(sum - initialEnergy + 1, 0);
//        System.out.println(ans);
        for (int i : experience) {
            if (initialExperience > i) initialExperience += i;
            else {
                int cnt = i - initialExperience + 1;
                ans += cnt;
                initialExperience += cnt + i;
            }
        }
//        System.out.println(ans);
        return ans;
    }
}
