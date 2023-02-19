package slidingwindow;

/**
 * 1234. 替换子串得到平衡字符串
 * https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 * 中等
 * 滑动窗口
 */
public class BalancedString {

    public int balancedString(String string) {
        char[] s = string.toCharArray();
        int n = s.length;
        int m = n / 4;
        int[] map = new int[26];

        for (char ch : s) {
            map[ch - 'A']++;
        }
        if (valid(map, m)) return 0;
        int ans = n;
        int left = 0, right = 0;
        for (; right < n; right++) {
            map[s[right] - 'A']--;
            while (valid(map, m)) {
                ans = Math.min(ans, right - left + 1);
                map[s[left++] - 'A']++;
            }
        }
        return ans;
    }

    public boolean valid(int[] map, int m) {
        return map['Q' - 'A'] <= m && map['W' - 'A'] <= m && map['E' - 'A'] <= m && map['R' - 'A'] <= m;
    }


}
