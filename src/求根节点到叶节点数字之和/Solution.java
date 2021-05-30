package 求根节点到叶节点数字之和;

public class Solution {
    int sums = 0;
    public int sumNumbers(TreeNode root) {
        if (root==null) return sums;
        getFatherNumbers(root,0);
        return sums;
    }
    public void  getFatherNumbers(TreeNode root,int num) {
        if (root.left==null&&root.right==null){
            sums+=num*10+root.val;
        }
        if (root.left!=null){
            getFatherNumbers(root.left,num*10+root.val);
        }
        if (root.right!=null){
            getFatherNumbers(root.right,num*10+root.val);
        }
    }
}
