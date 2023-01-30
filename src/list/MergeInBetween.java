package list;

/**
 * 1669. 合并两个链表
 * https://leetcode.cn/problems/merge-in-between-linked-lists/
 * 中等
 * 链表，模拟
 */
public class MergeInBetween {


    //自己写的
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list2Begin = list2;//记录list2的开始位置
        ListNode list2End = null;//记录list2的结束位置
        while (list2.next != null) {
            list2 = list2.next;
            if (list2.next == null) list2End = list2;
        }
        ListNode dummy = new ListNode(0, list1);
        ListNode list1Begin = null;//记录list1的a-1索引位置
        ListNode list1End = null;//记录list1的b的索引位置
        //遍历的时候更改指针，会改变遍历的顺序
        //dummy指针在for中已经被改变
        for (int i = 0; i <= b; i++) {
            dummy = dummy.next;
            if (i == a - 1) list1Begin = dummy;
            if (i == b) list1End = dummy.next;
        }

        //改变指针指向
        list1Begin.next = list2Begin;
        list2End.next = list1End;
        return list1;
    }


    //官方解答
    public ListNode leetcode(ListNode list1, int a, int b, ListNode list2) {
        ListNode preA = list1;
        for (int i = 0; i < a - 1; i++) {
            preA = preA.next;
        }
        ListNode preB = preA;
        for (int i = 0; i < b - a + 2; i++) {
            preB = preB.next;
        }
        preA.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = preB;
        return list1;
    }

}
