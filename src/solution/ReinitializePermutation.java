package solution;

import java.util.Arrays;

/**
 * 1806. 还原排列的最少操作步数
 * https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 * 中等
 * 暴力模拟
 */
public class ReinitializePermutation {

    public int reinitializePermutation(int n) {
        int[] target = new int[n], perm = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = i;
            perm[i] = i;
        }

        int cnt = 0;
        while (true) {
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                //如果是偶数
                if ((i & 1) == 0) temp[i] = perm[i / 2];
                else temp[i] = perm[n / 2 + (i - 1) / 2];
            }
            //perm数组指向temp数组
            perm = temp;
            cnt++;
            if (Arrays.equals(perm, target)) break;
        }
        return cnt;
    }
}
