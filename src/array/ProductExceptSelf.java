package array;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * https://leetcode.cn/problems/product-of-array-except-self/description
 * 中等
 * 数组，前缀，后缀
 */
public class ProductExceptSelf {


    // 前缀乘积，后缀乘积，时间n，空间n
    public int[] productExceptSelfByPreSuf(int[] nums) {
        int n = nums.length;
        int[] preProduct = new int[n];
        int[] sufProduct = new int[n];
        preProduct[0] = 1;
        sufProduct[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            preProduct[i] = preProduct[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            sufProduct[i] = sufProduct[i + 1] * nums[i + 1];
        }

//        System.out.println(Arrays.toString(preProduct));
//        System.out.println(Arrays.toString(sufProduct));
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = preProduct[i] * sufProduct[i];
        }
        return ans;
    }

    // 使用一个变量跟踪前缀乘积，遍历nums时，更新，把后缀数组作为答案数组输出
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            ans[i] = ans[i + 1] * nums[i + 1];
        }
        int preProduct = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = preProduct * ans[i];
            preProduct *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] inputs = {1, 2, 3, 4};
//        int[] ans = new ProductExceptSelf().productExceptSelfByPreSuf(inputs);
        int[] ans = new ProductExceptSelf().productExceptSelf(inputs);
        System.out.println(Arrays.toString(ans));

    }
}