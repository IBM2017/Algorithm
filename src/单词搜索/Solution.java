package 单词搜索;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length*board[0].length<word.length()){
            return false;
        }
        if(board.length==1&&board[0].length==1){
            if(board[0][0] == word.charAt(0)){
                return true;
            }else{
                return false;
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (judge(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    private boolean judge(char[][] board,String word,int i,int j,int index){
        if (index == word.length()){
            return true;
        }
        System.out.println(i+","+j);
        if (board[i][j]==word.charAt(index)){
            board[i][j] = '0';
            if (i>0){
                if (judge(board,word,--i,j,++index))
                    return true;
                i++;index--;
            }
            if (i<board.length-1){
                if (judge(board,word,++i,j,++index))
                    return true;
                i--;index--;
            }
            if (j>0){
                if (judge(board,word,i,--j,++index))
                    return true;
                j++;index--;
            }
            if (j<board[0].length-1){
                if (judge(board,word,i,++j,++index))
                    return true;
                j--;index--;
            }
            board[i][j] = word.charAt(index);
        }
        return false;
    }

    public static void main(String[] as){
        char[][] broad = {{'A'}};
        Solution solution = new Solution();
        System.out.println(solution.exist(broad,"A"));
    }

}
