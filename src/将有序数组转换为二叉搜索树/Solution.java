package 将有序数组转换为二叉搜索树;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums,int begin,int end){
        if (begin>end) return null;
        int center = (begin+end)/2;
        TreeNode root = new TreeNode(nums[center]);
        if (begin==end) return root;
        root.left = sortedArrayToBST(nums,begin,center-1);
        root.right = sortedArrayToBST(nums,center+1,end);
        return root;
    }
}
