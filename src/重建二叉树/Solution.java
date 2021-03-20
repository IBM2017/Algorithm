package 重建二叉树;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 缓存中序遍历数组每个值对应的索引
    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.getVal());
        int leftTreeSize = inIndex - inL;
        root.setLeftNode(reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL));
        root.setRightNode(reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1));
        return root;
    }
 
}
