package 对链表进行插入排序;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode here = head;

        while(here!=null&&here.next!=null){
            if (here.val>here.next.val){
                ListNode next = here.next;
                here.next = next.next;
                head = insertList(next,head,here);
            }else{
                here = here.next;
            }
        }
        return head;
    }

    private ListNode insertList(ListNode here,ListNode head,ListNode end){
        if (here.val<=head.val){
            here.next = head;
            return here;
        }
        ListNode beginNode = head;
        while (beginNode.val<end.val){
            if (beginNode.val<=here.val&&beginNode.next.val>here.val){
                here.next=beginNode.next;
                beginNode.next=here;
                break;
            }
            beginNode = beginNode.next;
        }
        return head;
    }
}
