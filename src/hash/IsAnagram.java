package hash;

import java.util.Arrays;

//242. 有效的字母异位词
//https://leetcode.cn/problems/valid-anagram/
//数组作为哈希表
public class IsAnagram {
//在key的范围可控的情况下，用数组作为哈希表


    //可以使用Arrays.equals方法比较两个数组是否相等,并且字符数组效率高
    // 排序法
    public boolean isAnagramSort(String s, String t) {
        //先比较长度不相等，直接返回false
        if (s.length() != t.length()) return false;

        //转化为char数组
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        //排序
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        //Arrays.equals方法比较两个数组是否相等
        return Arrays.equals(ch1, ch2);
    }


    public boolean isAnagram(String s, String t) {
        //先比较长度不相等，直接返回false
        // 这里长度相等的判断不能省略，只有在长度相等的条件下，才能排除t包含s的情况
        if (s.length() != t.length()) return false;

        //建立一个26字母哈希表
        int[] table = new int[26];

        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            //这里是放在每个for里面判断用<
            if (table[t.charAt(i) - 'a'] < 0)
                return false;
        }

        return true;
    }


    public boolean way(String s, String t) {
        //建立一个26字母哈希表
        int[] table = new int[26];

        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
        }
        //这里直接判断不相等的情况
        for (int i : table) {
            if (i != 0) return false;
        }
        return true;
    }


    // map比较相等法
    public boolean mapEquals(String s, String t) {
        int[] sMap = new int[26];
        int[] tMap = new int[26];

        for (char c : s.toCharArray()) {
            sMap[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            tMap[c - 'a']++;
        }
        return Arrays.equals(sMap, tMap);

    }

}
