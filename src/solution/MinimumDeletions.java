package solution;

/**
 * 1653. 使字符串平衡的最少删除次数
 * https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
 * 中等，枚举
 */
public class MinimumDeletions {
    public int minimumDeletions(String s) {
        char[] chars = s.toCharArray();

        //定义右边要删除的a，和左边要删的b
        int righta = 0, leftb = 0;
        //遍历s，统计右边a的数量
        for (char aChar : chars) {
            if (aChar == 'a') righta++;
        }

        int res = righta;
        for (char aChar : chars) {
            if (aChar == 'a') righta--;
            else leftb++;
            res = Math.min(res, righta + leftb);
        }
        return res;
    }
}
