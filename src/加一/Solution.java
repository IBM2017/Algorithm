package 加一;

public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1;i>=0;i--){
            digits[i]++;
            if (digits[i]==10){
                digits[i]=0;
                if(i==0){
                    int[] newDigits = new int[digits.length+1];
                    newDigits[0] = 1;
                    return newDigits;
                }
            }else break;
        }
        return digits;
    }
}
