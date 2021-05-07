package 从中序与后序遍历序列构造二叉树;

class Solution {
    public TreeNode buildTree(int[] inorder,int[] postorder) {
        return buildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode buildTree(int[] inorder , int inbegin, int inend,int[] postorder, int postbegin, int postend  ) {
        if (postend-postbegin<1){
            if (postend-postbegin == 0){
                return new TreeNode(postorder[postend]);
            }else return null;
        }
        TreeNode root = new TreeNode(postorder[postend]);
        int center=0;
        for (int i=inbegin;i<=inend;i++){
            if (postorder[postend]==inorder[i]){
                center = i;
                break;
            }
        }
        root.left = buildTree(inorder,inbegin,center-1,postorder,postbegin,center-inbegin+postbegin-1);
        root.right = buildTree(inorder,center+1,inend,postorder,center-inbegin+postbegin,postend-1);
        return root;
    }
}
