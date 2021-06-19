package 比较版本号;

public class Solution {
    public int compareVersion(String version1, String version2) {
        version1 = version1.trim();
        version2 = version2.trim();
        int ver1Cur = 0,ver2Cur = 0;
        while (ver1Cur<version1.length()&&ver2Cur<version2.length()){
            int end1 = ver1Cur,end2 = ver2Cur;
            int saveNum1,saveNum2;
            while (end1<version1.length()&&version1.charAt(end1) != '.'){
                end1++;
            }
            saveNum1 = Integer.parseInt(version1.substring(ver1Cur,end1));
            while (end2<version2.length()&&version2.charAt(end2) != '.'){
                end2++;
            }
            saveNum2 = Integer.parseInt(version2.substring(ver2Cur,end2));
            if (saveNum1>saveNum2) return 1;
            else if (saveNum1<saveNum2) return -1;
            ver1Cur=end1+1;
            ver2Cur=end2+1;
        }
        if (ver1Cur>=version1.length()){
            return -judgeMore(version2,ver2Cur);
        }else return judgeMore(version1,ver1Cur);

    }

    private int judgeMore(String str,int begin){
        while (begin<str.length()){
            int end = begin,num;
            while (end<str.length()&&str.charAt(end)!='.'){
                end++;
            }
            num = Integer.parseInt(str.substring(begin,end));
            if (num>0) return 1;
            begin = end+1;
        }
        return 0;
    }
}
