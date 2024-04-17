package hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. 字母异位词分组
 * https://leetcode.cn/problems/group-anagrams/description
 * 中等
 * 哈希，分组，排序，map中list元素的添加
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        // 给map中的list添加元素：
        // 方法一：通过先获取该list，再往里面添加元素，之后再放回map
        // 方法二：使用map的compute方法
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

//            List<String> list = map.getOrDefault(key, new ArrayList<>());
//            list.add(s);
//            map.put(key, list);

            map.compute(key, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(s);
                return v;
            });
        }
        // 获取map中所有的值，再放到一个list里面
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsStream(String[] strs) {
        // 一行
//        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(s -> Arrays.toString(s.codePoints().sorted().toArray()))).values());


        //s.codePoints()返回int流，根据int数组是否相同，判断是否为同一组
        Map<String, List<String>> map = Arrays.stream(strs)
                .collect(Collectors.groupingBy(
                        s -> {
                            int[] ints = s.codePoints().sorted().toArray();
                            String string = Arrays.toString(ints);
                            // 数组的字符串长这样 "[97, 98, 116]"
                            System.out.println(string);
                            return string;
                        })
                );
        Collection<List<String>> values = map.values();

        return new ArrayList<List<String>>(values);


    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagramsStream(strs));
        System.out.println(groupAnagrams.groupAnagrams(strs));

        // 打印的时候会打成以字符串的形式打印hello
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(chars);

//        String str = "Hello, World!";
//        str.codePoints().forEach(cp -> System.out.println(Character.toChars(cp)));


    }
}


