package 数组中重复的数字;

import java.util.Arrays;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int save = -1;
        for (int i =0;i<nums.length;i++){
            if (nums[i] == save) return save;
            save=nums[i];
        }
        return -1;
    }
}
