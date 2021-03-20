package 青蛙跳台阶问题;

public class Solution {
    public int numWays(int n) {
        int result1=1,result2=1;
        for (int i = 2;i<=n;i++){
            int a = (result1+result2)%1000000007;
            result1=result2;
            result2 = a;
        }
        return result2;
    }
}
