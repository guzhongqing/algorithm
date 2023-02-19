package doublepointer;

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 * 简单
 * 双指针,通过覆盖进行修改
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        //定义快慢指针，这里都从下标1开始，因为下标0的元素肯定在新数组中
        int slow = 1, fast = 1;
        for (; fast < nums.length; fast++) {
            //当前fast指针所在元素在前面重复过了，则跳过，没重复则选取加入新数组
            if (nums[fast] != nums[fast - 1]) nums[slow++] = nums[fast];
        }
        return slow;
    }

    //暴力法O(n2),for遍历数组，判断是否重复，再一个for把后面的左右数往前移动一位
}
