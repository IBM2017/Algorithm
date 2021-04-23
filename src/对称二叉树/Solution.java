package 对称二叉树;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSameTree(root.left,root.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p!=null&&q==null)||(p==null&&q!=null)){
            return false;
        }
        if(p==null) return true;
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.right)&&isSameTree(p.right,q.left);
    }
}
