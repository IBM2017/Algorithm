package 二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        if (root==null) return nodes;
        loadNodes(root,nodes);
        return nodes;
    }
    public void loadNodes(TreeNode treeNode,ArrayList<Integer> nodes){
        if (treeNode.left!=null){
            loadNodes(treeNode.left,nodes);
        }
        nodes.add(treeNode.val);
        if (treeNode.right!=null){
            loadNodes(treeNode.right, nodes);
        }
    }
}
