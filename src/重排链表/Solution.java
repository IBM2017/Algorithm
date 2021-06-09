package 重排链表;

public class Solution {
    public void reorderList(ListNode head) {
        ListNode beginHead = head;
        if(head.next == null) return;
        ListNode endHead = getresver(getMiddle(head));
        mergeList(beginHead,endHead);
    }
    private ListNode getMiddle(ListNode head){
        ListNode fast=head,low=head;
        while (fast!=null){
            low=low.next;
            if (fast.next!=null){
                fast=fast.next.next;
            }else {
                fast = fast.next;
            }
        }
        return low;
    }
    private ListNode getresver(ListNode head){
        ListNode pre = null;
        ListNode next = head.next;
        while (head!=null){
            head.next = pre;
            pre = head;
            head = next;
            if (head!=null){
                next = head.next;
            }
        }
        return pre;
    }
    private void mergeList(ListNode begin,ListNode end){
        ListNode saveBegin,saveEnd;
        while (end!=null){
            saveBegin = begin;
            saveEnd = end;
            begin = begin.next;
            end = end.next;
            saveBegin.next = saveEnd;
            saveEnd.next = begin;
        }
        if(begin != null) begin.next = null;
    }
}
