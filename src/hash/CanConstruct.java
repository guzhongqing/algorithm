package hash;

//383. 赎金信
//https://leetcode.cn/problems/ransom-note/
//对于字符串用数组作为哈希表
public class CanConstruct {


    public boolean canConstruct(String ransomNote, String magazine) {

        //直接先判断字符串长度，如果ransomNote大于magazine，ransomNote中的所有字符不可能在magazine中都有
        if (ransomNote.length() > magazine.length()) return false;

        //建立26个小写字母哈希表
        int[] table = new int[26];

        //直接把字符串变成字符数组再遍历字符数组中的每个元素

        //把ransomNote中每个字符都放入hash表中
        for (char ch : ransomNote.toCharArray()) {
            table[ch - 'a']++;
        }

        for (char ch : magazine.toCharArray()) {
            table[ch - 'a']--;
        }

        //遍历哈希表
        for (int i : table) {
            if (i > 0) return false;
        }
        return true;

    }

}
