package 矩阵置零;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int[] save = new int[matrix.length+matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    save[i]=1;
                    save[matrix.length+j]=1;
                }
            }
        }
        for (int i=0;i<matrix.length;i++){
            if (save[i]==1){
                for (int j = 0;j<matrix[0].length;j++)
                    matrix[i][j]=0;
            }
        }

        for (int j=matrix.length;j<matrix.length+matrix[0].length;j++){
            if (save[j]==1){
                for (int i = 0;i<matrix.length;i++)
                    matrix[i][j-matrix.length]=0;
            }
        }
    }
}
