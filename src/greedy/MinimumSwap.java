package greedy;

/**
 * 1247. 交换字符使得字符串相同
 * https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/
 * 中等
 * 贪心
 */
public class MinimumSwap {


    public int minimumSwap(String s1, String s2) {
        int n = s1.length();
        int xy = 0, yx = 0;
        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            if (ch1 == 'x' && ch2 == 'y') xy++;
            if (ch1 == 'y' && ch2 == 'x') yx++;
        }
        if (((xy + yx) & 1) == 1) return -1;
        return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }
}
