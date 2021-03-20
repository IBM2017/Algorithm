package 不同路径2;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){//(int m, int n) {
        if(obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        int a=1,b=1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i==0&&obstacleGrid[i][j]==1){
                    a=0;
                }
                if (j==0&&obstacleGrid[i][j]==1){
                    b=0;
                }
                if (i == 0){
                    dp[i][j] = a;
                }
                else if (j == 0){
                    dp[i][j] = b;
                }
                else if (obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
