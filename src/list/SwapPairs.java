package list;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * 中等
 * 迭代
 */
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            ListNode node1 = curr.next;
            ListNode node2 = curr.next.next;

            //交换结点指针
            curr.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            //移动当前指针
            curr = curr.next.next;
        }
        return dummy.next;
    }
}
