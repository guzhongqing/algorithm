package list;

/**
 * 707. 设计链表
 * https://leetcode.cn/problems/design-linked-list/
 * 中等
 */
//单向链表
public class MyLinkedList {
    int size = 0;
    ListNode dummy = new ListNode();//虚拟头结点，不计算下标

    public MyLinkedList() {
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode curr = dummy;
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr.val;

    }

    public void addAtHead(int val) {
        addAtIndex(0, val);

    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        index = Math.max(0, index);
        ListNode curr = dummy;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        curr.next = new ListNode(val, curr.next);
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        ListNode curr = dummy;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
    }
}
