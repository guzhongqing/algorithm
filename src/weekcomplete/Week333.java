package weekcomplete;

import java.util.LinkedList;

/**
 * https://leetcode.cn/contest/weekly-contest-333
 */
public class Week333 {

    public static void main(String[] args) {

    }

    /**
     * 6365. 将整数减少到零需要的最少操作数
     * https://leetcode.cn/problems/minimum-operations-to-reduce-an-integer-to-0/
     *
     * @param n
     * @return
     */
    public int minOperations(int n) {

        return 1;

    }

    /**
     * 6362. 合并两个二维数组 - 求和法
     * https://leetcode.cn/problems/merge-two-2d-arrays-by-summing-values/
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int[] map = new int[1001];
        for (int[] ints : nums1) {
            int id = ints[0], val = ints[1];
            map[id] = val;
        }

        for (int[] ints : nums2) {
            int id = ints[0], val = ints[1];
            map[id] += val;
        }

        LinkedList<int[]> cnt = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) cnt.add(new int[]{i, map[i]});
        }

        int[][] ans = new int[cnt.size()][];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = cnt.get(i);
        }
        return ans;
    }
}
