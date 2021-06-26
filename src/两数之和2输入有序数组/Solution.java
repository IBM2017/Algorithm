package 两数之和2输入有序数组;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int begin =0,end = numbers.length-1;
        while (begin<end){
            int sum = numbers[begin]+numbers[end];
            if (sum>target){
                end--;
                continue;
            }
            if (sum<target){
                begin++;
                continue;
            }
            if (sum==target){
                int[] result = new int[2];
                result[0] = begin+1;
                result[1] = end+1;
                return  result;
            }
        }
        return null;
    }
}
