package solution;

/**
 * 2180. 统计各位数字之和为偶数的整数个数
 * https://leetcode.cn/problems/count-integers-with-even-digit-sum/
 * 简单
 * 暴力，取位
 */
public class CountEven {

    public int countEven(int num) {

        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            int number = i, sum = 0;
            while (number > 0) {
                int temp = number % 10;
                sum += temp;
                number /= 10;
            }
            if (sum % 2 == 0) cnt++;
        }
        return cnt;
    }


}
