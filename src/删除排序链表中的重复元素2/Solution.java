package 删除排序链表中的重复元素2;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode left=null,centre,right;
        centre = head;
        boolean sign = false;
        while (centre!=null&&(right=centre.next)!=null){
            if (centre.val==right.val){
                sign=true;
                centre.next = right.next;
                continue;
            }else if (sign){
                if (left!=null){
                    left.next=right;
                }else{
                    head=right;
                }
                centre=right;
                sign=false;
            }else {
                left = centre;
                centre = right;
            }
        }
        if (sign){
            if (left==null) return null;
            left.next=null;
        }
        return head;
    }

}
