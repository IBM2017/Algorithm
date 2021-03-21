package 子集;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums.length==0) {
            return res;
        }
        Deque<Integer> save = new ArrayDeque<>();
        for (int i =1;i<=nums.length;i++){
            dfs(res,save, nums, i, 0);
            save.clear();
        }
        return res;
    }

    private void dfs(List<List<Integer>> saves,Deque<Integer> save ,int[] nums,int n,int index){
        if (save.size()==n){
            saves.add(new ArrayList<>(save));
            return;
        }
        for (int i = index; i < nums.length - (n - save.size()) + 1; i++) {
            save.addLast(nums[i]);
            dfs(saves, save, nums,n, i+1);
            save.removeLast();
        }
    }

    public static void main(String[] ae){
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> res = solution.subsets(nums);
        for (List<Integer> num:res){
            for (int s:num){
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
