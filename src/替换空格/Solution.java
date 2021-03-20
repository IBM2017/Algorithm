package 替换空格;

public class Solution {
    public String replaceSpace(String s) {
        s.trim();
        return s.replaceAll(" ","%20");
    }
}
