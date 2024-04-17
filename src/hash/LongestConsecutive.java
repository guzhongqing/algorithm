package hash;

import java.util.HashSet;

/**
 * 128. 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/description
 * 中等
 * 哈希，剪枝，有序集合
 */
public class LongestConsecutive {
    // treeSet去重，排序，遍历判断
//    public int longestConsecutive(int[] nums) {
//        if (nums.length == 0) return 0;
//        // 使用treeSet红黑树，有序且不重复，但是插入复杂度为logn，n个元素为nlogn
//        SortedSet<Integer> treeSet = new TreeSet<>();
//        for (int num : nums) {
//            treeSet.add(num);
//        }
//        int[] sortedNums = new int[treeSet.size()];
//        int index = 0;
//        for (int num : treeSet) {
//            sortedNums[index++] = num;
//        }
//        System.out.println(Arrays.toString(sortedNums));
//        int max = 1;
//        int cnt = 1;
//        for (int i = 1; i < sortedNums.length; i++) {
//            if (sortedNums[i] - 1 == sortedNums[i - 1]) {
//                max = Math.max(max, ++cnt);
//            } else {
//                cnt = 1;
//            }
//        }
//        return max;
//    }

    // set作为哈希表,时间复杂度为n，if可以找到每个序列开始的那个，连续的序列只会被走一次，后面的会直接被剪枝掉
    public int longestConsecutive(int[] nums) {
        int longestNum = 0;
        // 使用hashSet对数组去重
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 遍历set，根据num-1找到每个序列最小的数字开始
        for (Integer num : set) {
            // 通过if进行剪枝
            if (!set.contains(num - 1)) {
                int cnt = 1;
                // 从这个最小数找比其+1的数，记录序列长度，
                while (set.contains(++num)) {
                    cnt++;
                }
                // 结束记录全局最大长度
                longestNum = Math.max(longestNum, cnt);
            }

        }
        return longestNum;
    }


    public static void main(String[] args) {
        int[] inputs = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        LongestConsecutive obj = new LongestConsecutive();
        int ans = obj.longestConsecutive(inputs);
        System.out.println(ans);

    }
}


