package 有效的括号;

import java.util.ArrayList;

public class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> str = new ArrayList<>();
        if (s.length()==0) return true;
        if (s.length()%2==1) return false;
        if (s.charAt(0)==')'||s.charAt(0)=='}'||s.charAt(0)==']')
            return false;
        else
            str.add(s.charAt(0));
        for (int i =1 ;i<s.length();i++){
            char target = s.charAt(i);
            if (target == ')'){
                if (str.get(str.size()-1)=='(')
                    str.remove(str.size()-1);
                else return false;
            }else if (target == '}'){
                if (str.get(str.size()-1)=='{')
                    str.remove(str.size()-1);
                else return false;
            }else if (target == ']'){
                if (str.get(str.size()-1)=='[')
                    str.remove(str.size()-1);
                else return false;
            }else str.add(target);
        }
        if (str.size() == 0)
            return true;
        else
            return false;
    }
}
