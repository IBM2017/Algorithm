package 路径总和;

public class Solution {
    int save = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left==null&&root.right==null){
            if (save+root.val == targetSum){
                return true;
            }
            return false;
        }
        save+=root.val;
        if (root.left==null){
            boolean result = hasPathSum(root.right,targetSum);
            save-=root.val;
            return result;
        }
        if (root.right==null){
            boolean result =hasPathSum(root.left,targetSum);
            save-=root.val;
            return result;
        }
        if (hasPathSum(root.left,targetSum)){
            return true;
        }
        if (hasPathSum(root.right,targetSum)){
            return true;
        }
        save-=root.val;
        return false;
    }
}
