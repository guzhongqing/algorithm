package list;

import java.util.HashSet;

/**
 * 环形链表 II
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 * 中等
 * 快慢指针，hash
 */
public class DetectCycle {
    //快慢指针，快指针每次两个节点，慢指针每次走一个节点，
    //所以快指针相对于慢指针就等于慢指针不动，快指针每次走一个节点去追慢指针，就一定能追到
    //空间o(1),时间O(n)
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }


    //hash，空间o(n),时间O(n)
    public ListNode hash(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) return p;
            else set.add(p);
            p = p.next;
        }
        return null;
    }

}
