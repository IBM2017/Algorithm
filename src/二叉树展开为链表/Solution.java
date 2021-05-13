package 二叉树展开为链表;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        getChild(root);
    }

    public TreeNode getChild(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        if (left!=null){
            root.right = getChild(left);
        }

        if (right!=null){
            TreeNode last = root;
            while (last.right!=null) last = last.right;
            last.right = getChild(right);
            last.left = null;
        }

        return root;
    }
}
