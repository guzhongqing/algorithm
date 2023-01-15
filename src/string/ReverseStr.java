package string;

/**
 * 541. 反转字符串 II
 * https://leetcode.cn/problems/reverse-string-ii/
 * 简单
 * 模拟
 */
public class ReverseStr {

        public String reverseStr(String s, int k) {
            int n = s.length();
            char[] arr = s.toCharArray();
            for (int i = 0; i < n; i += 2 * k) {
                reverse(arr, i, Math.min(i + k, n) - 1);
            }
            return new String(arr);
        }

        public void reverse(char[] arr, int left, int right) {
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }


}
