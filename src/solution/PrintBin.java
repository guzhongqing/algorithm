package solution;

/**
 * 面试题 05.02. 二进制数转字符串
 * https://leetcode.cn/problems/bianry-number-to-string-lcci/
 * 中等
 */
public class PrintBin {
    public String printBin(double num) {
        StringBuilder ans = new StringBuilder();
        ans.append("0.");
        while (ans.length() <= 32 && num != 0) {
            num *= 2;
            int digit = (int) num;
            ans.append(digit);
            num -= digit;
        }
        return ans.length() <= 32 ? ans.toString() : "ERROR";
    }
}
