package 旋转链表;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode begin = head;
        while (begin.next!=null){
            length++;
            begin=begin.next;
        }
        length++;
        begin.next=head;
        int move = length-k%length;
        if (move!=length){
            for (int i=0;i<move;i++){
                begin=begin.next;
            }
        }
        head = begin.next;
        begin.next=null;
        return head;
    }
}
