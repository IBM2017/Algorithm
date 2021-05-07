package 从前序与中序遍历序列构造二叉树;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length);
    }
    public TreeNode buildTree(int[] preorder, int prebegin,int preend , int[] inorder , int inbegin,int inend) {
        if (preend-prebegin<1){
            if (preend-prebegin == 0){
                return new TreeNode(preorder[prebegin]);
            }else return null;
        }
        TreeNode root = new TreeNode(preorder[prebegin]);
        int center=0;
        for (int i=inbegin;i<=inend;i++){
            if (preorder[prebegin]==inorder[i]){
                center = i;
                break;
            }
        }
        root.left = buildTree(preorder,prebegin+1,center-inbegin+prebegin,inorder,inbegin,center-1);
        root.right = buildTree(preorder,center-inbegin+prebegin+1,preend,inorder,center+1,inend);
        return root;
    }
}
