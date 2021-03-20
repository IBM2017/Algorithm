package 移除元素;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int begin = 0;
        int end = length-1;
        while (begin<length){
            if (nums[begin]==val){
                if (nums[end]==val){
                    end--;length--;
                    if (end==begin){
                        length--;
                        break;
                    }
                    continue;
                }
                nums[begin] = nums[end];
                end--;length--;begin++;
            }else begin++;
        }
        return length;
    }
}
