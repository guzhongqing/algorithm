package slidingwindow;

/**
 * 2379. 得到 K 个黑块的最少涂色次数
 * https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
 * 简单
 * 滑动窗口，典型案例
 */
public class MinimumRecolors {
    public static void main(String[] args) {
        String s = "WBBWWBBWBW";
        minimumRecolors(s, 7);
        s = "WBWBBBW";
        minimumRecolors(s, 2);

    }

    public static int minimumRecolors(String blocks, int k) {
        int ans = Integer.MAX_VALUE;
        int l = 0, r = k - 1;
        int n = blocks.length();
        char[] chars = blocks.toCharArray();
        while (r < n) {
            int cnt = 0;
            for (int i = l; i <= r; i++) {
                if (chars[i] == 'W') cnt++;
            }
            ans = Math.min(ans, cnt);
            l++;
            r++;
        }
//        System.out.println(ans);
        return ans;
    }


    public static int optimize(String blocks, int k) {
        int cnt = 0, l = 0, r = 0;
        int n = blocks.length();
        //初始化滑档窗口，移动r指针,结束后r指想k下标
        while (r < k) {
            cnt += blocks.charAt(r) == 'W' ? 1 : 0;
            r++;
        }
        //初始化结果为窗口状态的次数
        int res = cnt;
        //在每次滑动的时候只计算l，r指针改变的值
        while (r < n) {
            //加上r当前的值
            cnt += blocks.charAt(r) == 'W' ? 1 : 0;
            //减去l当前的值
            cnt -= blocks.charAt(l) == 'W' ? 1 : 0;
            //当前最小操作数
            res = Math.min(res, cnt);
            l++;
            r++;

        }
        return res;
    }


}
