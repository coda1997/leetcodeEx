package course;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        for(int i = 0;i<queue.size()-1;i++){
            queue.offer(queue.poll());
        }
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        for(int i = 0;i<queue.size()-1;i++){
            queue.offer(queue.poll());
        }
        var t = queue.poll();
        queue.offer(queue.poll());
        return t;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}