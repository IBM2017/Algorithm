package Excel表列序号;

public class Solution {
    public int titleToNumber(String columnTitle) {
        int save = 0;
        for (int i=0;i<columnTitle.length();i++){
            save*=26;
            save+=(columnTitle.charAt(i)-'A'+1);
        }
        return save;
    }
}
