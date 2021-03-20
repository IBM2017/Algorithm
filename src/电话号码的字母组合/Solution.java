package 电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> taget = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        List<Character[]> saves = new ArrayList<>();
        if (digits.length()==0) return taget;
        for (int i = 0;i<digits.length();i++){
            int num = digits.charAt(i)-'0';
            saves.add(chars(num));
        }
        strings("",-1,saves);
        return taget;
    }
    public Character[] chars(int num){
        if (num == 7){
            return new Character[]{'p','q','r','s'};
        }else if (num == 9){
            return new Character[]{'w','x','y','z'};
        }else if (num == 8){
            return new Character[]{'t','u','v'};
        }else {
            Character[] save = new Character[3];
            for (int i = 0; i<save.length;i++){
                save[i]=(char)('a'+(num-2)*3+i);
            }
            return save;
        }
    }
    public void strings(String string,int x,List<Character[]> saves){
        x=x+1;
        if (x<saves.size()){
            for (int y = 0;y<saves.get(x).length;y++){
                strings(string+saves.get(x)[y],x,saves);
            }
        }else taget.add(string);
    }
}
