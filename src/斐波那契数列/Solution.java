package 斐波那契数列;

public class Solution {
    public int fib(int n) {
        int result1=0,result2=0;
        for(int i=0;i<n;i++){
            if (i==1) {
                result2 = 1;continue;
            }
            int a = result1+result2;
            result1 = result2;
            result2 = a;
        }
        return result2;
    }
}
