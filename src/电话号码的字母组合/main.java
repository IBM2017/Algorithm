package 电话号码的字母组合;

import java.util.List;

public class main {
    public static void main(String[] a ){
        Solution solution = new Solution();
        List<String> str = solution.letterCombinations("2");
        for (String s:str){
            System.out.println(s);
        }
    }
}
