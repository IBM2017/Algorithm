package 寻找峰值;

public class Solution {

    public int findPeakElement(int[] nums) {
        return findPeakElement(nums,0,nums.length-1);
    }
    private int findPeakElement(int[] nums,int begin,int end){
        if(begin == end) return begin;
        int mid = (begin+end)/2;
        if(nums[mid]>nums[mid+1])
            return findPeakElement(nums,begin,mid);
        return findPeakElement(nums,mid+1,end);
    }
}
