package course;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ValidBrackets
 */
public class ValidBrackets {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    var item = stack.pop();
                    if (c == ']' && item != '[' || c == '}' && item != '{' || c == ')' && item != '(') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}