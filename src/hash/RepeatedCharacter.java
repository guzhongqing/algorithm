package hash;

/**
 * 2351. 第一个出现两次的字母
 * https://leetcode.cn/problems/first-letter-to-appear-twice/
 * 小写字符串用数组作为哈希表
 *
 * @author acoolfish
 */
public class RepeatedCharacter {

    public char repeatedCharacter(String s) {
        int[] table = new int[26];

        for (char ch : s.toCharArray()) {
            if (table[ch - 'a'] == 1) return ch;
            table[ch - 'a'] = 1;
        }
        return ' ';

    }


}
