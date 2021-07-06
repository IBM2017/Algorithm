package 最大数;

import java.util.PriorityQueue;

public class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for(int x: nums) heap.offer(String.valueOf(x));
        String res = "";
        while(heap.size() > 0) res += heap.poll();
        if(res.charAt(0) == '0') return "0";
        return res;
    }
}
