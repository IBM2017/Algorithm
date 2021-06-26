package Excel表列名称;

public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while (columnNumber> 0){
            str.insert(0,(char)('A'+(--columnNumber)%26));
            columnNumber/=26;
        }
        return str.toString();
    }
}
