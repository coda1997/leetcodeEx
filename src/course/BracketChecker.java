package course;

import java.util.Deque;
import java.util.LinkedList;


public class BracketChecker {
    public boolean isValid(String s) {
        var cc = s.toCharArray();
        var deque = new LinkedList<Character>();
        for (var c : cc) {
            if(c=='('||c=='['||c=='{'){
                deque.push(c);
            }else{
                if(deque.isEmpty()){
                    return false;
                }
                var t = deque.poll();
                if(!(c==')'&&t=='('||c=='}'&&t=='{'||c==']'&&t=='[')){
                    return false;
                }
            }
        }
        if (deque.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}