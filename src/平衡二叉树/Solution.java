package 平衡二叉树;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        int result = getCHildNodeLength(root);
        if (result == -1) return false;
        return true;
    }

    private int getCHildNodeLength(TreeNode root){
        if (root==null) return 0;
        int left = getCHildNodeLength(root.left);
        if (left == -1) return -1;
        int rigth = getCHildNodeLength(root.right);
        if (rigth == -1) return -1;
        int result = left-rigth;
        if (result<-1||result>1) return -1;
        if (left>rigth) return left+1;
        return rigth+1;
    }
}
