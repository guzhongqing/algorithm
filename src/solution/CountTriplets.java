package solution;

/**
 * 982. 按位与为零的三元组
 * https://leetcode.cn/problems/triples-with-bitwise-and-equal-to-zero/
 * 困难，模拟，哈希表优化
 */
public class CountTriplets {
    public int countTriplets(int[] nums) {
        //定义存储前两元的哈希表
        int[] map = new int[1 << 16];
        int cnt = 0;

        for (int num1 : nums) {
            for (int num2 : nums) {
                map[num1 & num2]++;
            }
        }

        for (int num3 : nums) {
            for (int i = 0; i < map.length; i++) {
                if ((num3 & i) == 0) cnt += map[i];
            }
        }
        return cnt;
    }
}
