package 删除链表的倒数第N个节点;

public class main {
    public static void main(String[] str){
        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
        Solution solution = new Solution();
        solution.removeNthFromEnd(a,1);
        ListNode head = a;
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
