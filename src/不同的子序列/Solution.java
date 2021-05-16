package 不同的子序列;

public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int [][] saves = new int[m+1][n+1];
        if (m<n) return 0;
        for (int i=0;i<m+1;i++){
            saves[i][n]=1;
        }
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                if (s.charAt(i)==t.charAt(j)){
                    saves[i][j] = saves[i+1][j]+saves[i+1][j+1];
                }else {
                    saves[i][j] = saves[i+1][j];
                }
            }
        }
        return saves[0][0];
    }
}
