package 有序链表转换二叉搜索树;


import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode sortedListToBST(ListNode head)  {
        List<Integer> nums = makeListToArray(head);
        return sortedArrayToBST(nums,0,nums.size()-1);
    }

    private List<Integer> makeListToArray(ListNode head){
        List<Integer> save = new ArrayList<>();
        while (head!=null){
            save.add(head.val);
            head=head.next;
        }
        return save;
    }

    private TreeNode sortedArrayToBST(List<Integer> nums, int begin, int end){
        if (begin>end) return null;
        int center = (begin+end)/2;
        TreeNode root = new TreeNode(nums.get(center));
        if (begin==end) return root;
        root.left = sortedArrayToBST(nums,begin,center-1);
        root.right = sortedArrayToBST(nums,center+1,end);
        return root;
    }
}
