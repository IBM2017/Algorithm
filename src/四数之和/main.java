package 四数之和;

import java.util.List;

public class main {
    public static void main(String[] str){
        Solution solution = new Solution();
        List<List<Integer>> saveNums = solution.fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0);
        for (List<Integer> s:saveNums){
            for (int x:s){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
}
