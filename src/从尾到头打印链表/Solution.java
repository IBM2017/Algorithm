package 从尾到头打印链表;

public class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode a = null;
        int length = 0;
        if (head==null) return new int[0];
        while (head.next!=null){
            ListNode b = head.next;
            head.next = a;
            a= head;
            head = b;
            length++;
        }
        head.next = a;

        int nums[] = new int[length];
        for (int i=0;i<length;i++){
            nums[i] = head.val;
            head=head.next;
        }
        return nums;

    }
}
