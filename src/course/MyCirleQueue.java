package course;

class MyCircularQueue {
    private int[] queue;
    private int head = 0;
    private int end = 0;
    private int len;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        len = k+1;
        queue = new int[k+1];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
            //the queue is full
        }else{
            queue[end] = value;
            end = (end+1)%len;
            return true;
        }
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }else{
            head = (head+1)%len;
            return true;
        }
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return queue[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return queue[(end-1+len)%len];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head==end;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (end+1)%len==head;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */