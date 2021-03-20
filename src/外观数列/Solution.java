package 外观数列;

public class Solution {
    public String countAndSay(int n) {
        StringBuilder str = new StringBuilder();
        str.append(1);
        StringBuilder saveStr = new StringBuilder();
        saveStr.append("11");
        int[] save = {0,0,0};
        while (--n>0){
            save[str.charAt(0)-'1']++;
            for (int i = 1;i<str.length();i++){
                if (str.charAt(i)==str.charAt(i-1)){
                    save[str.charAt(i)-'1']++;
                }else{
                    save[str.charAt(i)-'1']++;
                    saveStr.append(save[str.charAt(i-1)-'1']);
                    save[str.charAt(i-1)-'1']=0;
                    saveStr.append(str.charAt(i-1));
                }
                if (i==str.length()-1){
                    saveStr.append(save[str.charAt(i)-'1']);
                    save[str.charAt(i)-'1']=0;
                    saveStr.append(str.charAt(i));
                }
            }
            save[0]=0;
            System.out.println("saveStr"+saveStr.toString());
            str.delete(0,str.length());
            str.append(saveStr.toString());
            saveStr.delete(0,saveStr.length());
        }
        System.out.println("最终结果"+str.toString());
        return str.toString();
    }
}
