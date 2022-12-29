package hash;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//349. 两个数组的交集
//https://leetcode.cn/problems/intersection-of-two-arrays/
//set作为哈希表
public class Intersection {


    public int[] intersection(int[] nums1, int[] nums2) {

        //定义一个个集合作为哈希表和一个结果集合，
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        //遍历第一个数组，把第一个数组放入集合，
        for (int i : nums1) {
            set.add(i);
        }

        //遍历第二个数组，去哈希表里去找，如果找到，就放入结果集合
        for (int i : nums2) {
            if (set.contains(i)) {
                resSet.add(i);
            }
        }

        //原始方式把set转化为int数组,效率比stream()方法快
        int[] res = new int[resSet.size()];
        int index = 0;
        //遍历set
        for (Integer integer : resSet) {
            res[index++] = integer;
        }

        //把set转为int数组,mapToInt映射对于每个x返回一个x，效率要慢一点
        return resSet.stream().mapToInt(x -> x).toArray();
    }


    //直接使用数组作为哈希表
    public int[] ints(int[] nums1, int[] nums2) {

        //定义一个数组作为哈希表
        int[] map = new int[1001];

        //结果集合
        Set<Integer> resSet = new HashSet<>();

        //遍历第一个数组，把第一个数组放入哈希表，当前元素的值设置为1
        for (int index : nums1) {
            map[index] = 1;
        }

        //遍历第二个数组，去哈希表里去找，如果找到，就放入结果集合
        for (int index : nums2) {
            if (map[index] == 1) {
                resSet.add(index);
                //把已经放入resSet的元素标记为0
            }
        }

        //原始方式把set转化为int数组,效率比stream()方法快
        int[] res = new int[resSet.size()];
        int index = 0;
        //遍历set
        for (Integer integer : resSet) {
            res[index++] = integer;
        }

        return res;
    }

    //使用list作为结果集，并手动去重
    public int[] list(int[] nums1, int[] nums2) {

        //定义一个数组作为哈希表,这里可以使用boolean数组，
        int[] map = new int[1001];
        //list作为结果集，这里可以使用ArrayList
        LinkedList<Integer> resList = new LinkedList<>();

        //遍历第一个数组，把第一个数组放入哈希表，当前元素的值设置为1
        for (int index : nums1) {
            map[index] = 1;
        }

        //遍历第二个数组，去哈希表里去找，如果找到，就放入结果集合
        for (int item : nums2) {
            if (map[item] == 1) {
                resList.add(item);
                //把已经放入resSet的元素标记为0,手动去重
                map[item] = 0;
            }
        }

        //原始方式把set转化为int数组,效率比stream()方法快
        int[] res = new int[resList.size()];
        //遍历list,list用get方法
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;

    }


}
