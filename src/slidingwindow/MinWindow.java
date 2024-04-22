package slidingwindow;

/**
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
 * 困难
 * 滑动窗口，哈希表
 */
public class MinWindow {

    // 暴力 时间n3,超时
    public String minWindowByFor(String s, String t) {
        String ans = "";
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }
        int[] tMap = new int[128];
        for (char c : t.toCharArray()) {
            tMap[c - 'A']++;
        }

        char[] sCharArray = s.toCharArray();
        for (int i = 0; i < sLen; i++) {
            for (int j = i + tLen - 1; j < sLen; j++) {
                // 计算i到j中字符数量
                int[] sMap = new int[128];
                for (int k = i; k <= j; k++) {
                    sMap[sCharArray[k] - 'A']++;
//                    System.out.print(sCharArray[k]);
                }
//                System.out.println();
                // 比较
                boolean flag = true;
                for (int index = 0; index < sMap.length; index++) {
                    if (sMap[index] < tMap[index]) {
                        flag = false;
                        break;
                    }
                }
                // s包含全部t
                if (flag) {
                    // [i,j)
                    if (ans.isEmpty()) {
                        ans = s.substring(i, j + 1);
                    } else {
                        ans = ans.length() < s.substring(i, j + 1).length() ? ans : s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    // 滑动窗口，哈希表 时间n+m 空间n 字符集长度
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        // 排除特殊情况
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        // 'A'65 'Z'90 'z'122
        char[] tMap = new char[128];
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }

        // 窗口中存储的字符
        char[] winMap = new char[128];

        // 类似汉明距离来判断窗口是否含有全部的tMap，当d==tLen时代表满足
        int distance = 0;
        int left = 0, right = 0;

        // 最终结果窗口,初始为不可能的大区间[winBeginIndex,winEndIndex)
        int winBeginIndex = 0;
        int winEndIndex = sLen + 1;
        while (right < sLen) {
            // 比较对应字符的数量,可能会出现tMap中的字符数为0
            // tMap[s.charAt(right)不为0代表t字符串中有这个字符，此时小于代表，窗口中的某个字符出现的次数不够t中该字符出现次数
            // tMap[s.charAt(right)为0代表t字符串中没有这个字符，此时一定不满足判断，直接跳过
            if (winMap[s.charAt(right)] < tMap[s.charAt(right)]) {
                // 有tMap中元素+1
                distance++;
            }
            // 窗口字符计数+1
            winMap[s.charAt(right)]++;
            // 右指针右移
            right++;

            // 判断是否全部包含，左指针右移，
            while (distance == tLen) {
                // 记录全局最小满足条件的窗口
                // 当前窗口比全局最小还小,此时right已经+1所有事[left，right)
                if (right - left < winEndIndex - winBeginIndex) {
                    winBeginIndex = left;
                    winEndIndex = right;
                }

                // 判断当前所指向字符是否是tMap中的字符，且刚好到达和tMap中一样的次数
                // winMap里面不可能为0，当tMap为0，一定为false，会直接跳过
                if (winMap[s.charAt(left)] == tMap[s.charAt(left)]) {
                    // 是tMap中的字符，这个字符被从窗口中移去
                    distance--;
                }
                // 窗口字符计数-1
                winMap[s.charAt(left)]--;
                // 左指针右移
                left++;
            }
        }
        // [begin,end)
        return winEndIndex == sLen + 1 ? "" : s.substring(winBeginIndex, winEndIndex);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
//        String s = "DOBECODEBANC", t = "A";
        MinWindow minWindow = new MinWindow();
//        String ans = minWindow.minWindowByFor(s, t);
        String ans = minWindow.minWindow(s, t);
        System.out.println(ans);
    }

}
