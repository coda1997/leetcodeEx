package course;

import java.util.Deque;
import java.util.LinkedList;

class CQueue {
    private Deque<Integer> stack;;
    private Deque<Integer> tempS;

    public CQueue() {
        stack = new LinkedList<>();
        tempS = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack.push(value);

    }

    public int deleteHead() {
        if(stack.isEmpty()){
            return -1;
        }
        while (!stack.isEmpty()) {
            tempS.push(stack.pop());
        }
        var res = tempS.pop();
        while(!tempS.isEmpty()){
            stack.push(tempS.pop());
        }
        return res;
    }
}