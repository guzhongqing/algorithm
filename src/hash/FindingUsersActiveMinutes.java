package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1817. 查找用户活跃分钟数
 * https://leetcode.cn/problems/finding-the-users-active-minutes/
 * 中等
 * hash，map中放入set的使用
 */
public class FindingUsersActiveMinutes {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //遍历每一条记录，并把他们去重放到map中
        for (int[] log : logs) {
            int id = log[0], time = log[1];
            //如果id不在中，则创建一个value类型为hashset的map
            map.putIfAbsent(id, new HashSet<>());
            //获取id的value，给hashset加入元素
            Set<Integer> set = map.get(id);
            //这里的set是一个指针，指向map中的value
            set.add(time);
        }
        int[] answer = new int[k];
        //遍历map中的value
        for (Set<Integer> set : map.values()) {
            int size = set.size();
            answer[size - 1]++;
        }
        return answer;
    }
}
