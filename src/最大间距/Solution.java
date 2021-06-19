package 最大间距;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length<2) return 0;
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int[] save = new int[nums.length];
        int mul = 1;
        while (maxValue>=mul){
            int[] pointer = new int[10];
            for (int i=0;i<nums.length;i++){
                pointer[(nums[i]/mul)%10]++;
            }
            for (int i =1;i<10;i++){
                pointer[i]+=pointer[i-1];
            }
            for (int i=nums.length-1;i>=0;i--){
                int cur = (nums[i]/mul)%10;
                save[pointer[cur]-1] = nums[i];
                pointer[cur]--;
            }
            System.arraycopy(save, 0, nums, 0, nums.length);
            mul *= 10;
        }
        int ret = 0;
        for (int i = 1; i < nums.length; i++) {
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        }
        return ret;
    }
}
