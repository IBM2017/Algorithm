package 二叉树的锯齿形层序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root != null){
            insertList(root,0);
        }
        return lists;
    }

    public void insertList(TreeNode root, int time){
        if (lists.size()==time){
            List<Integer> save = new ArrayList<>();
            save.add(root.val);
            lists.add(save);
        }else {
            if (time%2==0){
                lists.get(time).add(root.val);
            }else {
                lists.get(time).add(0,root.val);
            }

        }
        if (root.left!=null){
            insertList(root.left,time+1);
        }
        if (root.right!=null){
            insertList(root.right,time+1);
        }
    }
}
