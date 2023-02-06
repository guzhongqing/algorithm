package stackAndQueue;

import java.util.LinkedList;

/**
 * 20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 * 简单
 * 栈
 */
public class IsValid {

    public boolean isValid(String s) {
        //创建stack
        LinkedList<Character> stack = new LinkedList<>();
        //遍历s
        for (char ch : s.toCharArray()) {
            //判断每一个括号
            if (ch == '(') stack.push(')');
            else if (ch == '[') stack.push(']');
            else if (ch == '{') stack.push('}');
            else if (stack.isEmpty() || ch != stack.pop()) return false;
        }
        //最后判断是否全部匹配，若果左边括号多了，stack是不会空的
        return stack.isEmpty();
    }
}
