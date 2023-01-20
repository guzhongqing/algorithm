package list;

/**
 * 203. 移除链表元素
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * 简单
 */
public class RemoveElements {

    //遍历链表，删除val
    public ListNode removeElements(ListNode head, int val) {

        //循环删除头结点
        while (head != null && head.val == val) {
            //移动头结点
            head = head.next;
        }

        //循环删除中间值为val的结点
        ListNode curr = head;//定义当前指针
        //删除值为val结点的本质是让前一个结点跳过当前结点指向后一个结点
        while (curr != null && curr.next != null) {
            //删除curr.next结点
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                //移动当前结点
                curr = curr.next;
            }
        }
        return head;
    }

    //使用虚拟头结点
    public ListNode virHead(ListNode head, int val) {
        //初始化虚拟头结点
        ListNode vHead = new ListNode();
        //虚拟头结点接入链表
        vHead.next = head;
        //当前结点
        ListNode curr = vHead;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return vHead.next;
    }
}
