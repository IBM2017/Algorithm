package 二进制中1的个数;

public class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
