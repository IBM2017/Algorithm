package 搜索插入位置;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        if (nums.length ==1){
            if (nums[0]>=target) return 0;
            else return 1;
        }
        int left = 0,right = nums.length-1;
        if (nums[left]>=target) return 0;

        if (nums[right]==target) return nums.length-1;
        else if(nums[right]<target) return nums.length;
        while (left<right){
            int center = (right-left)/2 + left;
            if (nums[center] == target) return center;
            if (nums[center]>target) right = center;
            else left = center;
            if (right == left+1){
                return right;
            }
        }
        return 0;
    }
}
