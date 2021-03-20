package 有效的数独;

public class Solution {
    boolean[][][] saves = new boolean[3][9][9];
    public boolean isValidSudoku(char[][] board) {
        for (int row =0;row<9;row++){
            for (int col = 0;col<9;col++){
                if(board[row][col] == '.') continue;
                if (!rowJudge(board,row,col)||!colJudge(board,row,col)||!boxJudge(board,row,col))
                    return false;
            }
        }
        return true;
    }

    private boolean rowJudge(char[][] board,int row,int col){
        if (saves[0][row][board[row][col]-'1'])
            return false;
        else {
            saves[0][row][board[row][col]-'1'] = true;
            return true;
        }
    }

    private boolean colJudge(char[][] board,int row,int col){
        if (saves[1][board[row][col]-'1'][col])
            return false;
        else {
            saves[1][board[row][col]-'1'][col] = true;
            return true;
        }
    }

    private boolean boxJudge(char[][] board,int row,int col){
        if (saves[2][row/3*3+col/3*3][board[row][col]-'1'])
            return false;
        else {
            saves[2][row/3*3+col/3*3][board[row][col]-'1'] = true;
            return true;
        }
    }

}
