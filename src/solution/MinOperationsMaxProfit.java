package solution;

/**
 * 1599. 经营摩天轮的最大利润
 * https://leetcode.cn/problems/maximum-profit-of-operating-a-centennial-wheel/
 * 中等，模拟
 */
public class MinOperationsMaxProfit {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int curProfit = 0;//当前利润
        int waitingCus = 0;//正在等待的游客
        int maxPro = 0;//最大利润
        int minCnt = 0;//最小次数
        int cnt = 0;//总次数
        for (int customer : customers) {
            cnt++;
            waitingCus += customer;
            int enterCus = Math.min(waitingCus, 4);
            waitingCus -= enterCus;
            curProfit += enterCus * boardingCost - runningCost;
            if (curProfit > maxPro) {
                maxPro = curProfit;
                minCnt = cnt;
            }
        }
        while (waitingCus > 0) {
            cnt++;
            int enterCus = Math.min(waitingCus, 4);
            waitingCus -= enterCus;
            curProfit += enterCus * boardingCost - runningCost;
            if (curProfit > maxPro) {
                maxPro = curProfit;
                minCnt = cnt;
            }
        }
        return maxPro > 0 ? minCnt : -1;
    }
}
