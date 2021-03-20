package 合并K个排序链表;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> saves = new ArrayList<>();
        for(int i = 0;i<lists.length;i++){
            while (lists[i]!=null){
                saves.add(lists[i].val);
                lists[i]=lists[i].next;
            }
        }
        Collections.sort(saves);
        if (saves.size()==0) return null;
        ListNode newlist = new ListNode(saves.get(0));
        ListNode head = newlist;
        for (int i =1;i<saves.size();i++){
            ListNode a = new ListNode(saves.get(i));
            newlist.next = a;
            newlist = newlist.next;
        }
        return head;
    }
}
