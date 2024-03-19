package slidingwindow;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * 中等
 * 滑动窗口，使用哈希表优化记录元素和索引
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int longestLen = 0;
        char[] chars = s.toCharArray();
        int left = 0;
        for (int right = 0; right < chars.length; right++) {
            if (map.containsKey(chars[right])) {
                // 防止出现重复的元素时，是左指针已经走过的元素，所以使用最大值的保证left是最新的，而不会往左移动
                left = Math.max(map.get(chars[right]) + 1, left);

            }
            // 重复的元素会被替换掉
            map.put(chars[right], right);
            longestLen = Math.max(longestLen, right - left + 1);
            System.out.println(left + " " + right);


        }
        return longestLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        String s = "abba";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

}


