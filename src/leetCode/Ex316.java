package leetCode;

import java.util.*;

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

    public String removeDuplicateLetters2(String s) {
        Deque<Character> stack = new LinkedList<>();
        int[] cs = new int[26];
        var cc = s.toCharArray();
        boolean[] visited = new boolean[26];
        stack.offer(cc[0]);
        visited[cc[0]-'a'] = true;
        for (int i = 1; i < cc.length; i++) {
            cs[cc[i]-'a']++;
        }
        for (int i = 1; i < cc.length; i++) {
            if(!visited[cc[i]-'a']){
                while (!stack.isEmpty()&&cc[i]<stack.peek()&&cs[stack.peek()-'a']>0){
                    visited[stack.pop()-'a']=false;
                }
                stack.push(cc[i]);
                visited[cc[i]-'a'] = true;
            }
            cs[cc[i]-'a']--;
        }
        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var o = new Ex316();
        System.out.println( o.removeDuplicateLetters2("bcabc"));
        System.out.println( o.removeDuplicateLetters2("cbacdcbc"));
        System.out.println( o.removeDuplicateLetters2("cdadabcc"));
        System.out.println( o.removeDuplicateLetters2("ecbacba"));
    }
}
