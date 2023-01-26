package string;

/**
 * 1663. 具有给定数值的最小字符串
 * https://leetcode.cn/problems/smallest-string-with-a-given-numeric-value/
 * 中等
 * 贪心，前面都是a，后面都是z，当前前面a不满足k时，a开始加
 */
public class GetSmallestString {

    public String getSmallestString(int n, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int lower = Math.max(1, k - (n - i) * 26);
            k -= lower;
            ans.append((char) ('a' + lower - 1));
        }
        return ans.toString();
    }
}

