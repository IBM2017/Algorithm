package 验证回文串;

public class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while (i>j){
            char a =s.charAt(i);
            char b = s.charAt(j);
            if (!judgeChar(a)){
                i++;
                continue;
            }
            if (!judgeChar(b)){
                j--;
                continue;
            }
            if (changeChar(a)==changeChar(b)){
                i++;j--;
            }else {
                return false;
            }
        }
        return true;
    }
    private boolean judgeChar(char a){
        if (a>='a'&&a<='z'||a>='A'&&a<='Z'||a>='0'&&a<='9')
            return true;
        return false;
    }
    private char changeChar(char a){
        if (a>='a'&&a<='z'||a>='0'&&a<='9')
            return a;
        return (char)(a+('a'-'A'));
    }
}
