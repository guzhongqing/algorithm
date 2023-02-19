package doublepointer;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/
 * 简单
 * 双指针,要对原数组进行修改，数组没有删除都有覆盖
 */
public class RemoveElement {

    //双指针(快慢指针)
    public int removeElementOn(int[] nums, int val) {
        int slow = 0;//初始化慢指针，表示新数组的下标
        //遍历快指针
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) nums[slow++] = nums[fast];
            //slow指针指向新数组最后一个下标的下一个，即数组长度
        }
        return slow;
    }


    //暴力
    public int removeElementOn2(int[] nums, int val) {

        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                //后面数组往前覆盖一位
                for (int j = i + 1; j < size; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }
}
