package 螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> save = new ArrayList<>();
        if (matrix.length==0) return save;
        int left = 0,up=0,right=matrix[0].length-1,down=matrix.length-1;
        while (left<=right&&up<=down){
            for (int i = left;i<right;i++){
                save.add(matrix[up][i]);
            }
            for (int i = up;i<down;i++){
                save.add(matrix[i][right]);
            }
            for (int i = right ; i>left;i--){
                save.add(matrix[down][i]);
            }
            for (int i=down;i>up;i--){
                save.add(matrix[i][left]);
            }
            left++;right--;
            up++;down--;
        }
        if (save.size()<matrix[0].length*matrix.length){
            save.add(matrix[matrix.length/2+1][matrix[0].length/2+1]);
        }
        for (int i = save.size();i>matrix[0].length*matrix.length;i--){
            save.remove(i-1);
        }
        return save;
    }
}
