package 最长连续序列;

import java.util.Arrays;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length<2) return nums.length;
        int maxLength=1,saveLength=1,save = nums[0];
        for (int i = 1;i<nums.length;i++){
            if(nums[i]==save) continue;
            if (nums[i]!=save+1){
                if (saveLength>maxLength){
                    maxLength = saveLength;
                }
                saveLength = 1;
            }else {
                saveLength++;
                if(i==nums.length-1){
                    if (saveLength>maxLength){
                        maxLength = saveLength;
                    }
                }
            }
            save = nums[i];
        }
        return maxLength;
    }
}
