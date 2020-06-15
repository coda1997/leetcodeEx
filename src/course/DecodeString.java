package course;

import java.util.Deque;
import java.util.LinkedList;

import javax.swing.plaf.nimbus.State;

public class DecodeString {

    public String decodeString(String s) {
        var stringbuilder = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        
        for (var ch : s.toCharArray()) {
            if(Character.isLetterOrDigit(ch)||ch=='['){
                stack.push(ch);
            }else if(ch==']'){
                String buffer = "";
                while(stack.peek()!='['){
                    buffer = stack.pop()+buffer;
                }
                stack.pop();
                String num = "";
                while(!stack.isEmpty()&&Character.isDigit(stack.peek())){
                    num = stack.pop()+num;
                }
                var numInt = Integer.parseInt(num);
                for (int i = 0; i < numInt; i++) {
                    for (Character character : buffer.toCharArray()) {
                        stack.push(character);
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            stringbuilder.append(stack.pop());
        }
        return stringbuilder.reverse().toString();
    }
    public static void main(String[] args) {
        new DecodeString().decodeString("3[a2[c]]");
    }
}    