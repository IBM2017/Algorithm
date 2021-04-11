package 解码方法;

public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        int num0=1,num1=1;
        for(int i=1;i<s.length();i++){
            if (s.charAt(i)=='0'){
                if (s.charAt(i-1)>2||s.charAt(i-1)=='0')
                    return 0;
                continue;
            }else if (s.charAt(i-1)>'2'||s.charAt(i-1)=='0'||
                    (s.charAt(i-1)=='2'&&s.charAt(i)>'6')||
                    (i<s.length()-1&&s.charAt(i+1)=='0')){
                num0=num1;
            }else{
                int save = num0;
                num0=num1;
                num1 += save;
            }
        }
        return num1;
    }

}
