package 删除排序数组中的重复项2;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int time = 1;
        int end = nums.length-1;
        for (int i=1;i<=end;i++){
            if (nums[i-1]==nums[i]){
                time++;
                if (time>2){
                    moveNums(nums,1+i--,end--);
                }
            }else {
                time=1;
            }
        }
        return end+1;
    }

    private void moveNums(int[] nums,int begin,int end){
        for (int i=begin;i<=end;i++){
            nums[i-1]=nums[i];
        }
    }
}
