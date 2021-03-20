package 跳跃游戏;

public class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        if (nums.length==1) return true;
        for (int k=0;k<nums.length;k++){
            if (k+nums[k]>max){
                max = k+nums[k];
            }
            if (max == k) return false;
            if (max>=nums.length-1)
                return true;
        }
        return true;
    }
}
