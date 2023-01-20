package list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * 中等
 * 链表,快慢指针，虚拟头结点
 */
public class RemoveNthFromEnd {


    public static void main(String[] args) {
        ListNode node = new ListNode();
        System.out.println(node.val);
    }

    //计算链表长度
    public ListNode length(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }


    //使用虚拟结点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //初始化虚拟头结点，并让dummy.next=head
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        //快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //快慢指针同时走，当快指针的下一个为null时，fast所指向的就是最后一个元素
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //移除元素倒数第n个元素
        slow.next = slow.next.next;

        //返回链表头结点
        return dummy.next;
    }

    //栈
    public ListNode stack(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        assert prev != null;
        prev.next = prev.next.next;
        return dummy.next;
    }

}


