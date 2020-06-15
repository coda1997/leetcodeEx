package course;

import java.util.Deque;
import java.util.LinkedList;

class MyQueue {
    private Deque<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.removeLast();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack.peekLast();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}