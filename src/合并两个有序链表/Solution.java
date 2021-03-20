package 合并两个有序链表;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode begin,head;
        if (l1.val<=l2.val){
            begin = l1;
            l1= l1.next;
        }else {
            begin = l2;
            l2 = l2.next;
        }
        head = begin;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                begin.next = l1;
                begin = begin.next;
                l1 = l1.next;
            }else {
                begin.next = l2;
                begin = begin.next;
                l2=l2.next;
            }
        }
        if (l1 == null){
            begin.next = l2;
        }else {
            begin.next = l1;
        }
        return head;
    }
}
