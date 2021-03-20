package N皇后;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> saves = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] save = new char[n][n];
        add(save,0);
        return saves;
    }

    public void add(char[][] save,int i){
        if (i == save.length){
            ArrayList<String> value = new ArrayList<>();
            for (int j = 0;j<i;j++){
                value.add(String.valueOf(save[j]));
            }
            saves.add(value);
            return;
        }
        for (int j=0;j<save.length;j++){
            if (save[i][j]!='.'){
                char[][] newSave = deepCopyIntMatrix(save);
                newSave = change(newSave,i,j);
                add(newSave,i+1);
            }
        }
    }

    public static char[][] deepCopyIntMatrix(char[][] input) {
        if (input == null)
            return null;
        char[][] result = new char[input.length][];
        for (int r = 0; r < input.length; r++) {
            result[r] = input[r].clone();
        }
        return result;
    }

    public char[][] change(char[][] save,int i,int j){
        for (int k = i+1;k<save.length;k++){
            save[k][j]='.';
        }
        for (int k = 0;k<save.length;k++){
            if (k==j) {
                save[i][k]='Q';
                continue;
            }
            save[i][k] = '.';
        }
        for (int k = i+1, q = j-1; k<save.length&&q>=0;k++,q--){
            save[k][q] = '.';
        }
        for (int k = i+1, q = j+1; k<save.length&&q<save.length;k++,q++){
            save[k][q] = '.';
        }
        return save;
    }
}
