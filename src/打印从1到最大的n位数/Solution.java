package 打印从1到最大的n位数;

public class Solution {
    public int[] printNumbers(int n) {
        n = (int)Math.pow(10,n)-1;
        int[] result =new  int[n];
        for (int i=0;i<n;i++){
            result[i]=i+1;
        }
        return result;
    }
}
