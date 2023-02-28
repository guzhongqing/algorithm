package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2363. 合并相似的物品
 * https://leetcode.cn/problems/merge-similar-items/
 * 简单
 * 哈希表
 */
public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        int[] map = new int[1001];
        for (int[] value : items1) {
            map[value[0]] += value[1];
        }
        for (int[] ints : items2) {
            map[ints[0]] += ints[1];
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) res.add(Arrays.asList(i, map[i]));
        }
        return res;
    }
}
