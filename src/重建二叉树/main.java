package 重建二叉树;

public class main {
    public static void main(String[] a){
        Solution solution = new Solution();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        solution.reConstructBinaryTree(pre,in);
    }
}
