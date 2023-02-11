package priorityQueue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * 中等
 * 优先队列
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(Arrays.toString(topKFrequent(arr, 1)));
    }

    //大顶堆，优先队列维护map里面所有的元素
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //map初始化，key代表数字，value代表出现次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //按value降序，大根堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((next, curr) -> (curr[1] - next[1]));

        //遍历map，放入优先队列
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            pq.offer(new int[]{key, value});
        }

        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }


    //小顶堆，优先队列维护map里面前k个高频的元素
    public int[] smallHeap(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        //按value升序
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((next, curr) -> (next[1] - curr[1]));
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }


}
