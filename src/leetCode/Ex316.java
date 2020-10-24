package leetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Ex316 {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            map.put(s.charAt(i), i);
        }

        for (int i = 0;i<s.length();i++) {
            var item = s.charAt(i);
            if(!set.contains(item)){
                while(!stack.isEmpty()&&stack.peek()>item&&map.get(stack.peek())>i){
                    set.remove(stack.pop());
                }
                set.add(item);
                stack.push(item);

            }
        }
        var sb = new StringBuilder(stack.size());
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var o = new Ex316();
        System.out.println( o.removeDuplicateLetters("bcabc"));
        System.out.println( o.removeDuplicateLetters("cbacdcbc"));
        System.out.println( o.removeDuplicateLetters("cdadabcc"));
    }
}
