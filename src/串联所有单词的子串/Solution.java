package 串联所有单词的子串;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int begin = 0;
        HashSet<Integer> begins = new HashSet<>();
        int chandu = words[0].length();
        while ((begin = s.indexOf(words[0],begin))!=-1){
             Iterator wordsIte=makeList(words).iterator();
             int a = completeWords(s,wordsIte,begin-chandu,begin+chandu,chandu);
             if (a!=-1){
                 begins.add(a);
                 if (a<begin){
                     StringBuffer as = new StringBuffer();
                     for (int i = 0 ;i<chandu;i++){
                         as.append(" ");
                     }
                     s = s.substring(0,a)+as.toString()+s.substring(begin);
                     continue;
                 }
             }
             begin++;
        }
        return new ArrayList<>(begins);
    }

    private ArrayList<String> makeList(String[] words){
        ArrayList<String> a = new ArrayList<>();
        for (int i=1;i<words.length;i++){
            a.add(words[i]);
        }
        return a;
    }

    private int completeWords(String s, Iterator<String> words, int begin, int end,int changdu){
        while (words.hasNext()){
            String word = words.next();
            if (begin>=0&&s.substring(begin,begin+word.length()).compareTo(word)==0){
                words.remove();
                if (words.hasNext()){
                    return completeWords(s,words,begin-changdu,end,changdu);
                }else {
                    return begin;
                }
            }
            if (end<=s.length()-word.length()&&s.substring(end,end+word.length()).compareTo(word)==0){
                words.remove();
                if (words.hasNext()){
                    return completeWords(s,words,begin,end+changdu,changdu);
                }else {
                    return begin+changdu;
                }

            }

        }
        return -1;
    }


    public static void main(String[] a){
        Solution solution = new Solution();
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        for (int i:solution.findSubstring(s,words)){
            System.out.print(i+" ");
        }

    }

}
