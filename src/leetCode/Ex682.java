package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Ex682 {
    public int calPoints(String[] ops) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (String op :
                ops) {
            if (op.equals("+")) {
                int op1 = stack.pop();
                int op2 = stack.peek();
                stack.push(op1);
                stack.push(op1+op2);
            }else if (op.equals("D")){
                stack.push(stack.peek()*2);
            }else if (op.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.valueOf(op));
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
