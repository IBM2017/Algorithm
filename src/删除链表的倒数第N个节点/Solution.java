package 删除链表的倒数第N个节点;

import java.util.ArrayList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        int i = 0;
        while (head != null){
            listNodes.add(head);
            i++;
            head = head.next;
        }
        int j = i-n;
        if (j==0&&i== 1) return null;
        if (j == 0) return listNodes.get(1);

        ListNode hear = listNodes.get(j);
        ListNode presend = listNodes.get(j-1);
        presend.next = hear.next;
        return listNodes.get(0);
    }
}
