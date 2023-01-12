package hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 1807. 替换字符串中的括号内容
 * https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/
 * 中等
 * 哈希表
 */
public class Evaluate {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("123456");
        System.out.println(stringBuilder);
        stringBuilder.setLength(3);
        System.out.println(stringBuilder);
        stringBuilder.setLength(6);
        stringBuilder.append("#");
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
        System.out.println(stringBuilder);
        System.out.println("结束");
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> strings : knowledge) {
            //List下标从0开始
            map.put(strings.get(0), strings.get(1));
        }

        boolean flag = false;//定义括号状态
        StringBuilder key = new StringBuilder();//定义()中的key
        StringBuilder ans = new StringBuilder();//定义最终结果
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') flag = true;//状态为搜索key
            else if (ch == ')') {//结束key的搜索
                //如果key在map中有，则把key的value加入到ans中去，没有，则把？加入到ans中去
                ans.append(map.getOrDefault(key.toString(), "?"));
                //清空key
                key.setLength(0);
                //设置flag
                flag = false;
            } else {
                //根据flag判断当前搜索是在()里还是()外
                if (flag) key.append(ch);//在()里，给添加key
                else ans.append(ch);//在()外，给最终结果添加字符
            }
        }
        return ans.toString();
    }
}
