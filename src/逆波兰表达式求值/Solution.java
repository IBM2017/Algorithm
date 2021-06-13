package 逆波兰表达式求值;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> saves = new Stack<>();
        for (int i = 0;i<tokens.length;i++){
            if (tokens[i].length()>1){
                saves.push(Integer.parseInt(tokens[i]));
                continue;
            }
            if (tokens[i].charAt(0)>='0'&&tokens[i].charAt(0)<='9'){
                saves.push(tokens[i].charAt(0)-'0');
                continue;
            }

            if (tokens[i].charAt(0)=='*'){
                int a = saves.pop();
                int b = saves.pop();
                saves.push(a*b);
                continue;
            }
            if (tokens[i].charAt(0)=='-'){
                int a = saves.pop();
                int b = saves.pop();
                saves.push(b-a);
                continue;
            }
            if (tokens[i].charAt(0)=='+'){
                int a = saves.pop();
                int b = saves.pop();
                saves.push(a+b);
                continue;
            }
            if (tokens[i].charAt(0)=='/'){
                int a = saves.pop();
                int b = saves.pop();
                saves.push(b/a);
                continue;
            }
        }
        return saves.pop();
    }
}
