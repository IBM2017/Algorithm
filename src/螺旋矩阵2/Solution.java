package 螺旋矩阵2;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] save = new int[n][n];
        addNums(save,0,n-1,n-1,0,1);
        return save;
    }

    public void addNums(int[][] save,int left,int right,int down,int up,int begin){
        if (left>=right){
            return;
        }
        for (int i = left;i<right;i++){
            save[up][i]=begin;
            begin++;
        }
        for (int i = up;i<down;i++){
            save[i][right]=begin;
            begin++;
        }
        for (int i = right;i>left;i--){
            save[down][i]=begin;
            begin++;
        }
        for (int i = down;i>up;i--){
            save[i][left]=begin;
            begin++;
        }
        if(left==right){
            save[left][up]=begin;
        }
        addNums(save,left+1,right-1,down-1,up+1,begin);
    }
}
