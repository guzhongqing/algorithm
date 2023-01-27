package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 2309. 兼具大小写的最好英文字母
 * https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/
 * 简单
 * hash
 */
public class GreatestLetter {
    public String greatestLetter(String s) {



        Set<Character> ht = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ht.add(c);
        }
        for (int i = 25; i >= 0; i--) {
            if (ht.contains((char) ('a' + i)) && ht.contains((char) ('A' + i))) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }

}
