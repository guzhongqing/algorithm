package array;

import java.util.Arrays;

/**
 * 189. 轮转数组
 * https://leetcode.cn/problems/rotate-array
 * 中等
 * 数组，翻转数组
 */
public class Rotate {

    public void rotateByNew(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        // 移位到新数组
        for (int i = 0; i < n; i++) {
            ans[(i + k) % n] = nums[i];
        }
        // 复制回来
        System.arraycopy(ans, 0, nums, 0, n);
    }


    // 通过3次翻转数组实现原地 时间n，空间1
    public void rotateInSitu(int[] nums, int k) {
        int n = nums.length;
        // 这里k可能会大于数组长度，所以要mod，不然索引超了
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }


    // [begin,end]
    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Rotate rotate = new Rotate();
        rotate.rotateInSitu(inputs, k);
        System.out.println(Arrays.toString(inputs));
    }
}