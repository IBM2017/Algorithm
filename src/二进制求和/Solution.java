package 二进制求和;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuffer longStr;
        String shortStr;
        if (a.length()>b.length()){
            longStr = new StringBuffer(a);
            shortStr = b;
        }else {
            longStr = new StringBuffer(b);
            shortStr = a;
        }
        int jinwei = 0;
        int save;
        for (int i = longStr.length()-1;i>=longStr.length()-shortStr.length();i--){
            save = Integer.valueOf(longStr.charAt(i)+"")+Integer.valueOf(shortStr.charAt(i+shortStr.length()-longStr.length())+"") + jinwei;
            if (save>1){
                jinwei=1;
                longStr.replace(i,i+1,save-2+"");
            }
            else {
                jinwei = 0;
                longStr.replace(i,i+1,save+"");
            }
        }


        if (jinwei == 1){
            if (longStr.length()==shortStr.length()) longStr.insert(0,1);
            for (int i = longStr.length()-shortStr.length()-1;i>=0;i--){
                save = Integer.valueOf(longStr.charAt(i)+"")+jinwei;
                if (save>1){
                    jinwei=1;
                    longStr.replace(i,i,save-2+"");
                    if (i==0){
                        longStr.insert(0,1);
                    }
                }
                else {
                    jinwei = 0;
                    longStr.replace(i,i,save+"");
                }
                if (jinwei==0) break;
            }
        }
        return longStr.toString();
    }
}
