package 旋转图像;

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length==0) return;
        int length = matrix.length;
        for (int i=0;i<length/2;i++){
            for (int j=i;j<length-2-i;j++){
                int k = matrix[i][j];
                matrix[i][j] = matrix[length-1-i][j];
                matrix[length-i-1][j] = matrix[length-i-1][length-1-j];
                matrix[length-i-1][length-1-j] = matrix[i][length-1-j];
                matrix[i][length-1-j] = k;
            }
        }
    }
}
