package 交错字符串;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()) return false;
        if(s3.length()==0) return true;
        return judgeString(s1,0,s2,0,s3,0);
    }

    public boolean judgeString(String s1 , int i,String s2,int j,String s3,int k){
        if (k==s3.length()){
            return true;
        }
        if (i<s1.length()&&s3.charAt(k)==s1.charAt(i)&&judgeString(s1,i+1,s2,j,s3,k+1)){
            return true;
        }
        if (j<s2.length()&&s3.charAt(k)==s2.charAt(j)&&judgeString(s1,i,s2,j+1,s3,k+1)){
            return true;
        }
        return false;
    }
}
