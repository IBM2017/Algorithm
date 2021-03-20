package 用两个栈实现队列;

import java.util.Stack;

public class CQueue {

    Stack<Integer> one = new Stack<>();
    Stack<Integer> second = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        while (!second.empty()){
            one.push(second.pop());
        }
        one.push(value);
    }

    public int deleteHead() {
        while (!one.empty()){
            second.push(one.pop());
        }
        if (second.empty()) return -1;
        return second.pop();
    }
}
