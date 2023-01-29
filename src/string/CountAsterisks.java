package string;

/**
 * 2315. 统计星号
 * https://leetcode.cn/problems/count-asterisks/
 * 简单
 * 模拟,无难度
 */
public class CountAsterisks {

    public int countAsterisks(String s) {
        int cnt = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                flag = !flag;//取反
                continue;
            }
            if (flag && s.charAt(i) == '*') cnt++;
        }
        return cnt;
    }
}
