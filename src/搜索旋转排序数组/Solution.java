package 搜索旋转排序数组;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        if(nums.length == 0) return -1;
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        while (left<right){
            int center = (right-left)/2+left;
            if (nums[center]==target) return center;
            if (nums[left]>nums[center]){
                if (target>nums[left]) right = center;
                else if (target<nums[right]){
                    if (target > nums[center]) return zhongxu(nums,center,right,target);
                    else right = center;
                }else return -1;
            }else if (nums[left]<nums[center]){ //最大值在右边
                if (target<nums[right]) left = center;
                else if (target>nums[left]){
                    if (target>nums[center]) left = center;
                    else return zhongxu(nums,left,center,target);
                }else return -1;
            }else return -1;
        }
        return -1;
    }
    public int zhongxu(int[] nums,int left,int right,int target){
        while (left < right){
            int center = (right - left)/2+left;
            if (nums[center]==target) return center;
            else if (nums[center] > target) right = center;
            else left = center;
        }
        return -1;
    }
}
