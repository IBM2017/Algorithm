package 删除排序链表中的重复元素2简单;


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode centre,right;
        centre = head;
        while (centre!=null&&(right=centre.next)!=null){
            if (centre.val==right.val){
                centre.next = right.next;
                continue;
            }else {
                centre = right;
            }
        }
        return head;
    }
}
