package course;

import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (var character : tokens) {
            if(character.equals("+")){
                int t1 = Integer.parseInt(stack.pop());
                int t2 = Integer.parseInt(stack.pop());
                stack.push(t1+t2+"");
            }else if(character.equals("-")){
                int t2 = Integer.parseInt(stack.pop());
                int t1 = Integer.parseInt(stack.pop());
                stack.push(t1-t2+"");

            }else if(character.equals("*")){
                int t1 = Integer.parseInt(stack.pop());
                int t2 = Integer.parseInt(stack.pop());
                stack.push(t1*t2+"");
            }else if(character.equals("/")){
                int t2 = Integer.parseInt(stack.pop());
                int t1 = Integer.parseInt(stack.pop());
                stack.push(t1/t2+"");
            }else{
                stack.push(character);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}