package hash;

import java.util.HashMap;

/**
 * 454. 四数相加 II
 * https://leetcode.cn/problems/4sum-ii/
 * <p>
 * map作为hash表
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int key = n1 + n2;
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }

        for (int n3 : nums3) {
            for (int n4 : nums4) {
                int key = -(n3 + n4);
                if (map.containsKey(key)) {
                    cnt += map.get(key);
                }
            }
        }
        return cnt;
    }

}


