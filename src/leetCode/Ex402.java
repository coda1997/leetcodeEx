package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Ex402{
    public String removeKdigits(String num, int k) {
        var cc = num.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        int temp = 0;
        for (int i = 0; i < cc.length;) {
            var item = cc[i];
            if(stack.isEmpty()){
                stack.push(item);
                i++;
                continue;
            }
            if(item < stack.peek()&&temp<k){
                temp++;
                stack.pop();
            }else{
                i++;
                stack.push(item);
            }
        }

        while(temp<k&&!stack.isEmpty()){
            temp++;
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        while(sb.length()>0&&sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }

        var res = sb.toString();
        return res.length()>0?res:"0";
    }
    public static void main(String[] args) {
        var o = new Ex402();
        var res = o.removeKdigits("121", 1);
        System.out.println(res);
    }
}