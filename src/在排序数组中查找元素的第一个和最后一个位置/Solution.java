package 在排序数组中查找元素的第一个和最后一个位置;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] save = new int[]{-1,-1};

        if (nums.length == 0) return save;

        if (nums.length == 1&&nums[0]==target){
            save[0] = 0;save[1] = 0;return save;
        }else if (nums.length == 1) return save;

        if (nums[left]>target||nums[right]<target) return save;

        if (nums[left] == target) {
            save[0] = 0;
            save[1] = findRight(nums,left,right);
        }else if (nums[right] == target){
            save[0] = findLeft(nums,left,right);
            save[1] = right;
        }

        while (left+1 < right) {
            int center = (right - left) / 2 + left;
            if (nums[center] == target){
                save[0] = findLeft(nums,left,center);
                save[1] = findRight(nums,center,right);
                break;
            }
            if (nums[center]> target) right = center;
            else left = center;
        }
        return save;
    }

    public int findLeft(int[] nums, int left, int right) {
        if (right == left+1){
            if (nums[left]==nums[right]) return left;
            return right;
        }
        int center = (right - left) / 2 + left;
        if (nums[center] == nums[right] && nums[center - 1] != nums[right]) return center;
        else if (nums[center] == nums[right]) return findLeft(nums, left, center);
        else return findLeft(nums, center, right);
    }

    public int findRight(int[] nums, int left, int right){
        if (right == left+1){
            if (nums[left]==nums[right]) return right;
            return left;
        }
        int center = (right - left) / 2 + left;
        if (nums[center] == nums[left] && nums[center + 1] != nums[left]) return center;
        else if (nums[center] == nums[left]) return findRight(nums, center, right);
        else return findRight(nums, left, center);
    }
}
