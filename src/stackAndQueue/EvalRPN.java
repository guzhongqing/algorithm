package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 150. 逆波兰表达式求值
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * 中等
 * 栈，后缀表达式RPN
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if ("+".equals(token)) stack.push(stack.pop() + stack.pop());
            else if ("-".equals(token)) stack.push(-stack.pop() + stack.pop());
            else if ("*".equals(token)) stack.push(stack.pop() * stack.pop());
            else if ("/".equals(token)) {
                int t1 = stack.pop();
                int t2 = stack.pop();
                stack.push(t2 / t1);
            } else stack.push(Integer.valueOf(token));
        }
        return stack.pop();
    }
}
