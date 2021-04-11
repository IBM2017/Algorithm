package 反转链表2;

public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left==right) return head;
        ListNode before = findBefore(head,left);
        if (left >= 2){
            before.next = changeNode(before.next,left,right);
            return head;
        }else {
            return changeNode(before,left,right);
        }
    }

    private ListNode findBefore(ListNode head,int left){
        int i=1;
        while (i<left-1){
            head = head.next;
            i++;
        }
        return head;
    }

    private ListNode changeNode(ListNode begin,int left,int rigth){
        ListNode save;
        ListNode linkNode=begin;
        while (left<rigth){
            save = begin.next;
            begin.next = save.next;
            save.next = linkNode;
            linkNode = save;
            begin = begin.next;
            left++;
        }
        return linkNode;
    }
}
