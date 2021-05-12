package 路径总和2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> saves = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return saves;
        List<Integer> save = new ArrayList<>();
        getPathSum(root,targetSum,0,save);
        return saves;
    }
    public void getPathSum(TreeNode root, int targetSum,int value,List<Integer> save) {
        if (root.left == null && root.right == null){
            if (value+root.val == targetSum){
                List<Integer> newsave = new ArrayList<>(save);
                newsave.add(root.val);
                saves.add(newsave);
                return;
            }
        }
        save.add(root.val);
        value+=root.val;
        if (root.left == null){
            getPathSum(root.right,targetSum,value,save);
        }else if (root.right == null){
            getPathSum(root.left,targetSum,value,save);
        }else {
            getPathSum(root.right,targetSum,value,save);
            getPathSum(root.left,targetSum,value,save);
        }
        save.remove(save.size()-1);
        value-=root.val;
    }
}
