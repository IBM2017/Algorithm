package 二叉树的后序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> saves = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        getValue(root);
        return saves;
    }

    private void getValue(TreeNode root){
        if (root==null) return;
        getValue(root.left);
        getValue(root.right);
        saves.add(root.val);
    }
}
