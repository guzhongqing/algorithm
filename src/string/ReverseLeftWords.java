package string;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 简单
 * 使用整体反转+局部反转就可以实现反转单词顺序的目的。
 */
public class ReverseLeftWords {


    //API
    public String API(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }


    public String reverseLeftWords(String s, int n) {
        char[] ans = s.toCharArray();

        reverse(ans, 0, n - 1);
        reverse(ans, n, ans.length - 1);

        reverse(ans, 0, ans.length - 1);


        return new String(ans);
    }

    public void reverse(char[] chars, int i, int j) {
        while (i < j) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
            i++;
            j--;
        }
    }


}
