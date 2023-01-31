package array;

/**
 * 704. 二分查找
 * https://leetcode.cn/problems/binary-search/
 * 简单
 * 二分法
 */
public class Search {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int ans = search(arr, -1);
        System.out.println(ans);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }
}
