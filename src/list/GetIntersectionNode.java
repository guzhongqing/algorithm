package list;

import java.util.HashSet;

/**
 * 面试题 02.07. 链表相交
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 * 简单
 * hash,双指针
 */
public class GetIntersectionNode {
    //hash
    // 时间复杂度O(m+n),m,n为两个链表长度
    // 空间复杂度O(m)，其中m是链表A的长度，哈希集合存储链表A的全部结点
    public ListNode hash(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();//集合

        //先把链表A放入集合
        ListNode temp = headA;//临时指针，指向headA结点
        while (temp != null) {
            set.add(temp);
            temp = temp.next;//移动指针
        }

        //再把链表B放入集合，如果某个结点已经在集合中，则这个结点就是相交结点
        temp = headB;//临时指针，指向headB结点
        while (temp != null) {
            if (set.contains(temp)) return temp;
            temp = temp.next;//移动指针
        }
        return null;
    }

    //双指针
    // 时间复杂度O(m+n),m,n为两个链表长度
    // 空间复杂度O(1),没有创建集合
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //定义两个指针
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
