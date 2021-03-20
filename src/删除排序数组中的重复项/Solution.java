package 删除排序数组中的重复项;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1,j=1;
        if (nums.length<2) return nums.length;
        for (;j<nums.length;j++){
            if (nums[j]!=nums[j-1]){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}
