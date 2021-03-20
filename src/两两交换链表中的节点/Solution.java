package 两两交换链表中的节点;

import java.util.ArrayList;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next ==null ) return head;

        ListNode saveHead = head.next;
        ListNode presend = null;
        while (head.next!=null){
            ListNode a = head.next;
            ListNode b = a.next;

            a.next = head;
            head.next = b;
            head = b;
            if (presend != null) presend.next = a;
            presend = a.next;
        }
        return saveHead;
    }
}
