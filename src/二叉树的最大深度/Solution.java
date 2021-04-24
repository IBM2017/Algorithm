package 二叉树的最大深度;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left>=right){
            return left+1;
        }
        return right+1;
    }
}
