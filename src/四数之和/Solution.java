package 四数之和;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> saveNums = new ArrayList<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length<4) return saveNums;
        Arrays.sort(nums);
        for (int x = 0;x<nums.length-3;x++){
            if (x>0&&nums[x]==nums[x-1]) continue;
            for (int y = x+1;y<nums.length-2;y++){
                if (y>x+1&&nums[y]==nums[y-1]) continue;
                int newTaget = target-nums[x]-nums[y];
                if (newTaget>nums[nums.length-1]+nums[nums.length-2])
                    continue;
                getNums(newTaget,x,y,nums);
            }
        }
        return saveNums;
    }

    private void getNums(int num,int x,int y,int[] nums){
        int min = y+1,max = nums.length-1;

        while (min < max){
            if (num>nums[min]+nums[max]){
                min++;
                while (nums[min]==nums[min-1]) min++;
            }else if (num<nums[min]+nums[max]){
                max--;
                while (nums[max]==nums[max+1]) max--;
            }else {
                List<Integer> save = new ArrayList<>();
                save.add(nums[x]);
                save.add(nums[y]);
                save.add(nums[min]);
                save.add(nums[max]);
                saveNums.add(save);
                min++;
                while (min<nums.length&&nums[min]==nums[min-1]) min++;
                max--;
                while (max>y&&nums[max]==nums[max+1]) max--;
            }
        }
    }

}
