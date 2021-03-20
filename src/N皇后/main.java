package N皇后;

import java.util.List;

public class main {
    public static void main(String[] as){
        Solution solution = new Solution();
        List<List<String>> saves = solution.solveNQueens(4);
        for (List<String> s:saves){
            for (String str:s){
                System.out.println(str);
            }
            System.out.println();
        }
        char[][] sasd = new char[4][4];
        sasd[0][0] = 's';
        char[][] sad = sasd.clone();
        sasd[0][0] = 'a';
        System.out.println(sad[0][0]);
    }
}
