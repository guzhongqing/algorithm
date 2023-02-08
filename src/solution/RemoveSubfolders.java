package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 1233. 删除子文件夹
 * https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem/
 * 中等
 * 排序，set作为哈希表，字典树
 */
public class RemoveSubfolders {


    //hash
    public List<String> removeSubfolders(String[] folder) {
        //数组转List，通过set的构造方法直接转为set
        HashSet<String> set = new HashSet<>(Arrays.asList(folder));
        for (String f : folder) {
            StringBuilder sb = new StringBuilder();
            String[] split = f.split("/");
            //不包括自己
            for (int i = 1; i < split.length - 1; i++) {
                sb.append("/").append(split[i]);
                if (set.contains(sb.toString())) {
                    set.remove(f);
                    break;
                }
            }
        }
        //set转list，直接用构造
        return new ArrayList<>(set);
    }


    //按字典序排序

    public List<String> sort(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; ++i) {
            int pre = ans.get(ans.size() - 1).length();
            if (
                    !(
                            pre < folder[i].length() &&
                                    ans.get(ans.size() - 1).equals(folder[i].substring(0, pre)) &&
                                    folder[i].charAt(pre) == '/'
                    )
            ) {
                ans.add(folder[i]);
            }
        }
        return ans;
    }


}



