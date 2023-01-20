package list;

/**
 * 206. 反转链表
 * https://leetcode.cn/problems/reverse-linked-list/
 * 简单
 * 双指针法
 * 递归法
 */


public class ReverseList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        traversal(head);
        head = reverseList(head);
        traversal(head);

    }

    //遍历链表
    public static void traversal(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    //双指针
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //这里无需用一个新变量临时存储head.next结点，直接用head指向head.next结点就可以
            head = head.next;
            curr.next = prev;
            prev = curr;
            curr = head;
        }
        return prev;
    }

    //递归函数
    public ListNode reverse(ListNode perv, ListNode curr) {
        if (curr == null) return perv;
        //保存点next
        ListNode next = curr.next;
        //反转
        curr.next = perv;
        //移动双指针
        return reverse(curr, next);
    }

    //调用递归函数返回反转链表
    public ListNode reverse(ListNode head) {
        return reverse(null, head);
    }


    //直接递归,从后往前翻转指针指向
    public ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}


//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


