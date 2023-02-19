package priorityqueue;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1801. 积压订单中的订单总数
 * https://leetcode.cn/problems/number-of-orders-in-the-backlog/
 * 堆(优先队列)
 */
public class GetNumberOfBacklogOrders {

    //每个订单为[price,amount,typeOrder]数组
    public int getNumberOfBacklogOrders(int[][] orders) {

        final int MOD = 1000000007;
        //优先队列中每个元素是一个[price,amount]数组
        PriorityQueue<int[]> buyOrders = new PriorityQueue<>((next, curr) -> curr[0] - next[0]);//采购积压订单,优先级price从大到小,
        PriorityQueue<int[]> sellOrders = new PriorityQueue<>((next, curr) -> next[0] - curr[0]);//销售积压订单,优先级price从小到大,默认

        //遍历订单数组
        for (int[] order : orders) {
            //定义变量订单变量
            int price = order[0], amount = order[1], typeOrder = order[2];

            //判断订单类型
            if (typeOrder == 0) {//若为采购订单

                //循环判断,采购订单数量>0,并且优先队列sellOrders不为空,并且sellOrders队头的price要<=price,这里要先判断队列是否为空,为空则为false结束判断
                while (amount > 0 && !sellOrders.isEmpty() && sellOrders.peek()[0] <= price) {

                    //获取sellOrders的第一个订单,并从优先队列中删除
                    int[] sellOrder = sellOrders.poll();

                    //两边的订单数量同时减掉最小的订单数量
                    int sellAmount = Math.min(amount, sellOrder[1]);
                    amount -= sellAmount;
                    sellOrder[1] -= sellAmount;

                    //如果销售订单有剩余,则把当前的销售订单重新加到销售队列中
                    if (sellOrder[1] > 0) {
                        sellOrders.offer(sellOrder);
                    }
                }

                //如果最后采购订单还有剩余,则把当前的采购订单加到采购队列中
                if (amount > 0) {
                    buyOrders.offer(new int[]{price, amount});
                }

            } else {//若为销售订单,同上
                while (amount > 0 && !buyOrders.isEmpty() && buyOrders.peek()[0] >= price) {
                    int[] buyOrder = buyOrders.poll();
                    int buyAmount = Math.min(amount, buyOrder[1]);
                    amount -= buyAmount;
                    buyOrder[1] -= buyAmount;
                    if (buyOrder[1] > 0) {
                        buyOrders.offer(buyOrder);
                    }
                }
                if (amount > 0) {
                    sellOrders.offer(new int[]{price, amount});
                }
            }

        }

        //最后计算两个积压定单的总数
        int total = 0;
        for (PriorityQueue<int[]> pq : Arrays.asList(buyOrders, sellOrders)) {//把每个队列加到一个list中去,遍历每个队列元素
            while (!pq.isEmpty()) {
                total += pq.poll()[1] % MOD;
                total %= MOD;
            }
        }

        return total;
    }


}
