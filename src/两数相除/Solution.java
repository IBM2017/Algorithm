package 两数相除;

import 两两交换链表中的节点.ListNode;

public class Solution {
    public int divide(int dividend, int divisor) {
        int judge = 0;
        if(dividend<0&&divisor>0||dividend>0&&divisor<0){
            judge = -1;
        }else judge = 1;
        dividend = isFu(dividend);
        divisor = isFu(divisor);
        int value = 0;
        while (dividend<=divisor){
            dividend-=divisor;
            value--;
        }

        if (judge == -1 ) return value;
        if (value==Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return -value;
    }
    private int isFu(int a){
        if (a<=0) return a;
        else return -a;
    }
}
