package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//2032. 至少在两个数组中出现的值
//https://leetcode.cn/problems/two-out-of-three/
//数组作为哈希表
public class TwoOutOfThree {

    //数据少直接使用数组作为哈希表
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        List<Integer> ans = new ArrayList<>();


        return ans;
    }


    //使用map遍历entrySet，位运算
    public List<Integer> bitMapEntry(int[] nums1, int[] nums2, int[] nums3) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums1) {
            map.put(i, 1);//二进制位第一位标记为1
        }
        //通过位运算标记哪一几个数组有，001,010,100表示分别只有一二三数组有
        for (int i : nums2) {
            //map中有i就获取i的value，没有就获取0
            map.put(i, map.getOrDefault(i, 0) | 2);//二进制位第二位标记为1
        }
        for (int i : nums3) {
            map.put(i, map.getOrDefault(i, 0) | 4);//二进制位第三位标记为1
        }
        List<Integer> res = new ArrayList<Integer>();
        //遍历map集合中每一个entry
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey(), v = entry.getValue();
            //判断value的二进制位是否大于1
            if ((v & (v - 1)) != 0) {
                res.add(k);
            }
        }
        return res;
    }

    //使用集合
    public List<Integer> mapEntry(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList<Integer>();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //第一个数组直接放入map,标记为1个
        for (int i : nums1) {
            map.put(i, 1);
        }

        for (int i : nums2) {
            //如果map中含有i，则放入value++;
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);//不含有则放入value=1
        }

        for (int i : nums3) {
            //如果map中含有i，则放入value++;
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);//不含有则放入value=1
        }

        //遍历map，把value>=2的key放入res
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) res.add(entry.getKey());
        }

        return res;


    }


}
