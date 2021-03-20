package 组合总和2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length == 0) return answer;
        ArrayList<Integer> save = new ArrayList<>();
        judgeTree(save,0,target,candidates);
        return answer;
    }

    public void judgeTree(ArrayList<Integer> saveUp,int i,int target,int[] candidates){
        int start = i;
        for (;i<candidates.length;i++){
            if(i>start&&candidates[i]==candidates[i-1])
            {
                continue;
            }
            int newtarget = target - candidates[i];
            if (newtarget>0){
                ArrayList<Integer> saveNew = (ArrayList<Integer>) saveUp.clone();
                saveNew.add(candidates[i]);
                judgeTree(saveNew,i+1,newtarget,candidates);
            }else if (newtarget == 0){
                ArrayList<Integer> saveNew = (ArrayList<Integer>) saveUp.clone();
                saveNew.add(candidates[i]);
                answer.add(saveNew);
            }else
                return;
        }
    }
}
