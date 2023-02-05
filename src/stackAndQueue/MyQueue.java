package stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * 简单
 */
public class MyQueue {

    public static void main(String[] args) {
        //ArrayDeque中的push，pop，peek
        //push调用ArrayDeque中的addFirst方法
        //pop调用ArrayDeque中的removeFirst方法
        //peek调用ArrayDeque中的peekFirst方法
        ArrayDeque<Object> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque.peek());//3
        System.out.println(deque.pop());//3

        System.out.println(deque.peek());//2
        System.out.println(deque.pop());//2

        System.out.println(deque.peek());//1
        System.out.println(deque.pop());//1
    }

    Deque<Integer> inStack, outStack;

    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        in2out();
        return outStack.pop();
    }


    public int peek() {
        in2out();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    //把inStack中的所有元素出站，在入栈到outStack中
    public void in2out() {
        //若out不为空，即有元素，直接返回
        if (!outStack.isEmpty()) return;

        //in不为空，循环移动in到out
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }


}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */