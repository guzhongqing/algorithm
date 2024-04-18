package doublepointer;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes
 * 简单
 * 双指针
 */
public class MoveZeroes {
    // 以下两种解法都有一个问题，最开始出现连续的非0，会一直自己和自己交换赋值
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    // 右指针遍历整个数组，遇到非0几就和左指针交换，一开始都是非0的话，左右指针指向同一个数，自己交换
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    // 两次遍历，只管把非0放到前面，最后面的直接赋值为0就行
    // 这种好理解，好写
    public void moveZeroesByTwoFor(int[] nums) {
        int left = 0;
        int right = 0;
        for (; right < nums.length; right++) {
            if (nums[right] != 0) {
                // 右指针找到非0，赋值给左指针，左指针+1
                nums[left++] = nums[right];
            }
        }
        // 左指针后面都赋值为0
        for (; left < nums.length; left++) {
            nums[left] = 0;
        }
    }
    // 少写版
//    public void moveZeroes(int[] nums) {
//        int index=0;
//        for(int n:nums){
//            if(n!=0)
//                nums[index++]=n;
//        }
//        while(index<nums.length)
//            nums[index++]=0;
//    }


}
