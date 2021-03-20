package 字符串相乘;

public class Solution {
    String num1;
    String num2;
    StringBuffer result = new StringBuffer();
    int[] saveNums = new int[10];
    public void expandedNums(){
        int[] newSaveNums = new int[saveNums.length+10];
        System.arraycopy(saveNums,0,newSaveNums,0,saveNums.length);
        saveNums = newSaveNums;
    }

    public String multiply(String num1, String num2) {
        if (num1.length()<num2.length()){
            String t = new String(num1);
            num1 = num2;
            num2 = t;
        }
        for (int i = num2.length()-1;i>=0;i--){
            if (num2.charAt(i) == '0') continue;
            for (int j = num1.length()-1;j>=0;j--){
                if (num1.charAt(j) == '0') continue;
                carryAdd(bitMultiply(num1.charAt(j),num2.charAt(i)),num1.length()-j-1+num2.length()-i-1);
            }
        }
        Boolean first = false;
        for (int i = saveNums.length-1;i>=0;i--){
            if (saveNums[i]==0&&!first) continue;
            if (saveNums[i]!=0 && !first) first = true;
            result.append(saveNums[i]);
        }
        if (result.length()==0) return "0";
        return result.toString();
    }

    public void carryAdd(int num,int i){
        if (i == saveNums.length) expandedNums();
        int add = num+saveNums[i];
        if (add >= 10){
            saveNums[i] = add%10;
            carryAdd(add/10,i+1);
        }else {
            saveNums[i] = add;
        }
    }

    public int bitMultiply(char a,char b){
        int numA = a-'0';
        int numB = b-'0';
        return numA*numB;
    }
}
