package 二维数组中的查找;

public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length==0) return false;
        int x = 0,y = matrix[0].length-1;
        while (x<matrix.length&&y>=0){
            if (matrix[x][y]<target) x++;
            else if (matrix[x][y]>target) y--;
            else if (matrix[x][y] == target) {
                return true;
            }
        }
        return false;
    }
}
