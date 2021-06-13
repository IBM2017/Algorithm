package 翻转字符串里的单词;

public class Solution {
    public String reverseWords(String s) {
        String[] saves = s.split(" ");
        StringBuffer newStr = new StringBuffer();
        for (int i= saves.length-1;i>=0;i--){
            if (saves[i].length()==0) continue;
            newStr.append(saves[i] + " ");
        }
        if (newStr.length()!=0){
            newStr.deleteCharAt(newStr.length()-1);
        }
        return newStr.toString();
    }
}
