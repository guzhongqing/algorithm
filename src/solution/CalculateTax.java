package solution;

/**
 * 2303. 计算应缴税款总额
 * https://leetcode.cn/problems/calculate-amount-paid-in-taxes/
 * 简单
 * 模拟
 */
public class CalculateTax {

    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        int lower = 0;//初始化下限0
        for (int[] bracket : brackets) {
            int upper = bracket[0], percent = bracket[1];
            ans += (Math.min(income, upper) - lower) * percent;
            if (income <= upper) break;
            lower = upper;

        }
        return ans / 100.0;
    }
}
