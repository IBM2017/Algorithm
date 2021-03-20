package 爬楼梯;

public class Solution {
    public int climbStairs(int n) {
        int num1 = 1;
        int num0 = 1;
        for (int i = 2;i<=n;i++){
            int save = num0;
            num0=num1;
            num1 += save;
        }
        return num1;
    }
}
