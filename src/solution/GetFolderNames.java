package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 1487. 保证文件名唯一
 * https://leetcode.cn/problems/making-file-names-unique/
 * 中等
 */
public class GetFolderNames {

    public String addPreSuf(String name, int num) {
        return name + "(" + num + ")";
    }

    public String[] getFolderNames(String[] names) {
        int n = names.length;
        String[] ans = new String[n];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {//没有重复，直接记录
                //放入哈希表
                map.put(name, 1);
                //修改目标数组
                ans[i] = name;
            } else {//有重复的，去找加上()的
                Integer num = map.get(name);
                while (map.containsKey(addPreSuf(name, num))) num++;
                map.put(name, num + 1);
                map.put(addPreSuf(name, num), 1);
                ans[i] = addPreSuf(name, num);
            }
        }
        return ans;
    }
}
