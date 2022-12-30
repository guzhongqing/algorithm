package hash;

import java.util.*;

//2032. 至少在两个数组中出现的值
//https://leetcode.cn/problems/two-out-of-three/
//数组作为哈希表
public class TwoOutOfThree {

    //数据少直接使用数组作为哈希表
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        List<Integer> ans = new ArrayList<>();

        //获取每个数组的map
        int[] map1 = getMap(nums1);
        int[] map2 = getMap(nums2);
        int[] map3 = getMap(nums3);
        //遍历所有数据，判断出现次数
        for (int i = 1; i <= 100; i++) {
            if (map1[i] + map2[i] + map3[i] >= 2) ans.add(i);
        }

        return ans;
    }

    //获取每个数组的哈希表,已去重
    public int[] getMap(int[] ints) {
        int[] map = new int[101];
        for (int i : ints) {
            map[i] = 1;
        }
        return map;
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
        //每个数组进行去重
        HashSet<Integer> n1 = new HashSet<>();
        HashSet<Integer> n2 = new HashSet<>();
        HashSet<Integer> n3 = new HashSet<>();

        for (int i : nums1) {
            n1.add(i);
        }
        for (int i : nums2) {
            n2.add(i);
        }
        for (int i : nums3) {
            n3.add(i);
        }


        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //第一个数组直接放入map,标记为1个
        for (int i : n1) {
            map.put(i, 1);
        }

        for (int i : n2) {
            //如果map中含有i，则放入value++;
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);//不含有则放入value=1
        }

        for (int i : n3) {
            //如果map中含有i，则放入value++;
            if (map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);//不含有则放入value=1
        }


        List<Integer> res = new ArrayList<Integer>();
        //遍历map，把value>=2的key放入res
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) res.add(entry.getKey());
        }

        return res;


    }


}
