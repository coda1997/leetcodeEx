package leetCode;

import java.util.Stack;

public class Ex150 {
    public int evalRPN(String[] tokens) {
        if (tokens==null||tokens.length==0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(tokens[0]));
        for (int i = 1; i < tokens.length; i++) {
            String t = tokens[i];
            if (isOpeartor(t)){

                int p1 = stack.pop();
                int p2 = stack.pop();
                switch (t){
                    case "+":
                        stack.push(p2+p1);
                        break;
                    case "-":
                        stack.push(p2 - p1);
                        break;
                    case "*":
                        stack.push(p2 * p1);
                        break;
                    case "/":
                        stack.push(p2/p1);
                        break;
                        default:break;
                }
            }else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }

    private boolean isOpeartor(String op){
        if (op.length()!=1){
            return false;
        }
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }
}
