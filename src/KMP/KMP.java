package KMP;

public class KMP {
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int j =0,i=0;
        while (i<haystack.length()){
            if (haystack.charAt(i)!=needle.charAt(j)){
                j=next[j];
            }else {
                j++;
                i++;
                if (j==needle.length()) return 1;
            }
            if (j==-1){
                j++;
                i++;
            }
        }
        return 0;
    }

    private static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j<p.length-1){
            if (k==-1||p[j]==p[k]){
                next[++j] = ++k;
            }else {
                k=next[k];
            }
        }

        return next;
    }
}
