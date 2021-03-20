package 矩阵中的路径;

public class Solution {
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;
    //主操作函数
    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        //判断函数体是否规范
        if (rows == 0 || cols == 0) return false;
        //将数组的行列记录
        this.rows = rows;
        this.cols = cols;
        //创建boolean数组，记录路径
        boolean[][] marked = new boolean[rows][cols];
        //将字符串转化为矩形数组
        char[][] matrix = buildMatrix(array);
        //开始递归运算
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (backtracking(matrix, str, marked, 0, i, j))
                    return true;

        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str,
                                 boolean[][] marked, int pathLen, int r, int c) {
        if (pathLen == str.length) return true; //当前路径是否查询完毕
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || matrix[r][c] != str[pathLen] || marked[r][c]) {//判断当前位置是否越界，或者字符不匹配，或者当前记录位置已经查询
            return false;
        }
        marked[r][c] = true; //当前位置符合要求，标记为true
        for (int[] n : next)//将当前位置向剩下的三个方向扩展
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1]))
                return true;
        //该路径不合格，失效
        marked[r][c] = false;
        return false;
    }
    //将字符串转化为字符串数组
    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix[r][c] = array[idx++];
        return matrix;
    }

}
