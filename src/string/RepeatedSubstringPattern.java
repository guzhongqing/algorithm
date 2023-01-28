package string;

/**
 * 459. 重复的子字符串
 * https://leetcode.cn/problems/repeated-substring-pattern/
 * 简单
 * 暴力,api
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {

        System.out.println(API("abc"));
        System.out.println(ansFor("abc"));
    }


    public static boolean ansFor(String s) {
        int n = s.length();
        //子串长度从1开始，且小于等于s/2
        for (int subN = 1; subN * 2 <= n; subN++) {
            //n一定是子串长度的倍数
            if (n % subN == 0) {
                boolean match = true;
                //从子串长度的索引开始
                for (int i = subN; i < n; i++) {
                    //有一个不符合就为false
                    if (s.charAt(i) != s.charAt(i - subN)) {
                        match = false;
                        break;
                    }
                }
                if (match) return true;
            }
        }
        //没有一个sub符合，返回false
        return false;
    }


    //API
    public static boolean API(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
