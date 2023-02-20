package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2347. 最好的扑克手牌
 * https://leetcode.cn/problems/best-poker-hand/solution/
 * hash表计数
 */
public class BestHand {
    //数组作为hash
    public String bestHand(int[] ranks, char[] suits) {
        int[] ranksMap = new int[14];
        int[] suitsMap = new int[4];
        for (int rank : ranks) {
            ranksMap[rank]++;
        }
        for (char suit : suits) {
            suitsMap[suit - 'a']++;
        }
        for (int i : suitsMap) {
            if (i == 5) return "Flush";
        }
        for (int i : ranksMap) {
            if (i >= 3) return "Three of a Kind";
        }
        for (int i : ranksMap) {
            if (i == 2) return "Pair";
        }
        return "High Card";
    }


    //HashSet和HashMap
    public String API(int[] ranks, char[] suits) {
        Set<Character> suitsSet = new HashSet<Character>();
        for (char suit : suits) {
            suitsSet.add(suit);
        }
        if (suitsSet.size() == 1) {
            return "Flush";
        }
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int rank : ranks) {
            h.put(rank, h.getOrDefault(rank, 0) + 1);
        }
        if (h.size() == 5) {
            return "High Card";
        }
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            if (entry.getValue() > 2) {
                return "Three of a Kind";
            }
        }
        return "Pair";
    }


}
