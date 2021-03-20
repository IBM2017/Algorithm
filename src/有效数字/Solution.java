package 有效数字;

import java.util.regex.Pattern;

public class Solution {
    public boolean isNumber(String s) {
        char a = s.trim().charAt(s.trim().length()-1);
        if (a<=90&&a>=65||a<=122||a>=97) return false;
        try {
            Float.parseFloat(s);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
