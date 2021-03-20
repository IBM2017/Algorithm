package 正则表达式匹配;

public class Solution {
    public boolean isMatch(String s, String p) {
        int i=0,j=0;
        while (i<s.length()&&j<p.length()){
            if (j<p.length()-1&&p.charAt(j+1)=='*'){
                if ((p.charAt(j)=='.')||(p.charAt(j)==s.charAt(i))){
                    while (i<s.length()-1&&s.charAt(i)==s.charAt(i+1)){
                        i++;
                    }
                }
                i++;j+=2;
            }else if (p.charAt(j)=='.'){
                i++;j++;
            }else if (p.charAt(j)==s.charAt(i)){
                i++;j++;
            }else return false;
        }
        if (i==s.length()&&j==p.length()){
            return true;
        }return false;
    }
}
