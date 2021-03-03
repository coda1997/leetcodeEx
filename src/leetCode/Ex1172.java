package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Ex1172 {
    class DinnerPlates {
        private int capacity;
        private LinkedList<Deque<Integer>> list;
        public DinnerPlates(int capacity) {
            this.capacity = capacity;
            list = new LinkedList<>();
            list.addFirst(new LinkedList<>());
        }

        public void push(int val) {
            if (list.getLast().size()==capacity){
                list.addLast(new LinkedList<>());
            }
            list.getLast().push(val);
        }

        public int pop() {
            while (!list.isEmpty()&&list.getLast().isEmpty()) {
                list.removeLast();
            }
            if (list.isEmpty()) {
                return -1;
            }
            return list.getLast().pop();
        }

        public int popAtStack(int index) {
            if (list.size()<index){
                return -1;
            }
            var stack = list.get(index);
            return stack.isEmpty() ? -1 : stack.pop();
        }
    }
}
