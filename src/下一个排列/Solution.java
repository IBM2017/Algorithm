package 下一个排列;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int tag = 0;
        for(int i = nums.length-1;i>0;i--) {
            if (nums[i]>nums[i-1]){
                Arrays.sort(nums,i,nums.length);
                for (int j = i;j<nums.length;j++){
                    if (nums[i-1]<nums[j]){
                        int save = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = save;
                    }
                }
                tag = 1;
                break;
            }
        }

        if (tag == 0)
            Arrays.sort(nums);
    }
}
