package 寻找旋转排序数组中的最小值;

public class Solution {
    public int findMin(int[] nums) {
        int begin = 0,end = nums.length-1,cur;
        while (end>(begin+1)){
            cur = (begin+end)/2;
            if (nums[cur]<nums[begin]){
                end = cur;
            }else if(nums[cur]>nums[end]) {
                begin = cur;
            }else{
                return nums[begin];
            }
        }
        if(nums[begin]<nums[end]) return nums[begin];
        return nums[end];
    }
}