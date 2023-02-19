package doublepointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 151. 反转字符串中的单词
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 * 中等
 * 使用整体反转+局部反转就可以实现反转单词顺序的目的。
 */


public class ReverseWords {

    public static void main(String[] args) {
        String api = API("a good   example");
        api = reverseWords("the");
        System.out.println(api);
    }

    //调用API
    public static String API(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割,\\转义为\，\s是任何不可见字符，包括空格，回车符，换行符，换页符，制表符，+是一个或者多个这样的字符
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        //去除字符数组多余空格
        chars = trimSpace(chars);
        //反转字符数组
        reverse(chars, 0, chars.length - 1);
        //反转字符数组中每个单词
        reverseEachWords(chars);
        return new String(chars);
    }


    //用快慢指针删除两边，及中间多余空格
    public static char[] trimSpace(char[] chars) {
        int slow = 0, fast = 0;
        for (; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {

                //除第一个单词外，之后每一个单词前加上一个空格，加上空格
                if (slow != 0) chars[slow++] = ' ';
                //遍历单个单词，先判断fast是否越界
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }

            }
        }
        char[] newChars = new char[slow];
        //复制数组
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    public static void reverse(char[] chars, int l, int r) {
        while (l < r) swap(chars, l++, r--);
    }

    public static void reverseEachWords(char[] chars) {
        int l = 0, r = 0;
        for (; r <= chars.length; r++) {
            //先判断长度，等于length直接惊进行下面操作，不会索引越界
            if (r == chars.length || chars[r] == ' ') {
                reverse(chars, l, r - 1);
                l = r + 1;
                r++;
            }
        }
    }

    public static void swap(char[] chars, int l, int r) {
        chars[l] ^= chars[r];
        chars[r] ^= chars[l];
        chars[l] ^= chars[r];
    }


}
