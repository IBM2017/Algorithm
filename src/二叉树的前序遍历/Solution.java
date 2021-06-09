package 二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> saves = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        getValue(root);
        return saves;
    }

    private void getValue(TreeNode root){
        if (root==null) return;
        saves.add(root.val);
        getValue(root.left);
        getValue(root.right);
    }
}
