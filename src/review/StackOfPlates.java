package review;

import java.util.ArrayList;

public class StackOfPlates {
    class Stack{
        private final int capacity;
        private int[] nums;
        private int top;
        Stack(int capacity) {
            this.capacity = capacity;
            top = 0;
            nums = new int[capacity];
        }

        public void push(int value){
            if (top < capacity) {
                nums[top++] = value;
            }
        }
        public int size(){
            return top;
        }

        public int top() {
            if (top > 0) {
                return nums[top - 1];
            }
            return -1;
        }
        public int pop(){
            if (top>0){
                return nums[--top];
            }
            return -1;
        }
    }
    private ArrayList<Stack> stacks;
    private final int capacity;
    public StackOfPlates(int cap) {
        stacks = new ArrayList<>();
        this.capacity = cap;
    }

    public void push(int val) {
        if (stacks.size()==0){
            stacks.add(new Stack(capacity));
        }
        var stack = stacks.get(stacks.size()-1);
        if (stack.size()==capacity){
            stack = new Stack(capacity);
            stacks.add(stack);
        }
        stack.push(val);
    }

    public int pop() {
        if (stacks.size() == 0) {
            return -1;
        }
        var stack = stacks.get(stacks.size() - 1);
        //we can ensure the stack in stacks are all not empty
        var res = stack.pop();
        if (stack.size()==0){
            stacks.remove(stacks.size()-1);
        }
        return res;
    }

    public int popAt(int index) {
        if (index<0||index>=stacks.size()){
            return -1;
        }
        var stack = stacks.get(index);
        var res = stack.pop();
        if (stack.size() == 0) {
            stacks.remove(stack);
        }
        return res;
    }
}
