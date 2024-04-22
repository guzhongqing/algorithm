package array;

import java.util.*;

/**
 * 56. 合并区间
 * https://leetcode.cn/problems/merge-intervals/
 * 中等
 * 数组
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        // 按左边点升序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
//        方法一：
//        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
//        方法二：
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            public int compare(int[] interval1, int[] interval2) {
//                return interval1[0] - interval2[0];
//            }
//        });


        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

