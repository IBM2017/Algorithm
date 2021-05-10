package 二叉树的层序遍历2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> saves = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root!=null){
            addInteger(root,0);
        }
        return saves;
    }
    private void addInteger(TreeNode root,int time){
        int i = saves.size()-time-1;
        if (i<0){
            List<Integer> save = new ArrayList<>();
            save.add(root.val);
            saves.add(0,save);
        }
        else {
            saves.get(i).add(root.val);
        }
        if (root.left!=null){
            addInteger(root.left,time+1);
        }
        if (root.right!=null){
            addInteger(root.right,time+1);
        }

    }
}
