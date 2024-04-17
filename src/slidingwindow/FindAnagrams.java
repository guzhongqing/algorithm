package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 * 中等
 * 用哈希表存储滑动窗口，通过比较哈希表是否相同，来确定是否符合要求，模拟滑动窗口移动
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        // 定义结果数组
        ArrayList<Integer> ans = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        // 如果字符串的长度都有小于异位词，不可能有符合的
        if (sLen < pLen) {
            return new ArrayList<>();
        }

        // 构建哈希表, sMap是维持的窗口，pMap是用来比较的窗口
        int[] sMap = new int[26];
        int[] pMap = new int[26];

        // 填充哈希表，以p为基准
        for (int i = 0; i < pLen; i++) {
            sMap[s.charAt(i) - 'a']++;
            pMap[p.charAt(i) - 'a']++;
        }


        // 通过比较两个哈希表是否相同判断初始状态是否符合
        if (Arrays.equals(sMap, pMap)) {
            ans.add(0);
        }

        // 遍历哈希表,左边指针从最左边开始，只需要移动sLen-pLen次
        for (int i = 0; i < sLen - pLen; i++) {
            // s窗口的左指针向右移动，代表窗口元素减少，对应元素map--，
            // 注意左指针移除的元素，是窗口的第一个元素

            sMap[s.charAt(i) - 'a']--;

            // s窗口的右指针向右移动，代表窗口元素增加，对应元素map++，
            // 注意右指针加入的元素，是窗口的下一个元素
            sMap[s.charAt(i + pLen) - 'a']++;
            // 判断
            if (Arrays.equals(sMap, pMap)) {
                // 添加左指针，当前位置
                ans.add(i + 1);
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> integerList = new FindAnagrams().findAnagrams(s, p);
        System.out.println(integerList);
    }
}
