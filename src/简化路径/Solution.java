package 简化路径;

import java.util.ArrayList;

public class Solution {
    public String simplifyPath(String path) {
        String[] reasults = path.split("/");
        ArrayList<String> saves = new ArrayList<>();
        for (int i=0;i<reasults.length;i++){
            if (reasults[i].length()==0||reasults[i].compareTo(".")==0) continue;
            if (reasults[i].compareTo("..")==0){
                if (saves.size()!=0) {
                    saves.remove(saves.size()-1);
                }
                continue;
            }
            saves.add(reasults[i]);
        }
        StringBuilder sb =  new  StringBuilder();
        for  ( int  i =  0 ; i <  saves.size() ; i++) {
            sb.append("/"+saves.get(i));
        }
        if (sb.length()==0){
            sb.append("/");
        }
        return sb.toString();
    }

    public static void main(String[] a){
        Solution solution = new Solution();
        solution.simplifyPath("/..//./.hpm/");
    }
}
