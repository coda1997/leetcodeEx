package course;

import java.util.ArrayList;

public class CalculateTwo {
    public int calculate(String s) {
        //first we should split <s> into tokens
        var ss = s.toCharArray();
        var tokens = new ArrayList<String>();
        var nums = new ArrayList<Integer>();
        int temp = 0;
        boolean isNumber = false;
        for (int i = 0; i < ss.length; i++) {
            var item = ss[i];
            if(Character.isDigit(item)){
                temp = temp*10+(item-'0');
                isNumber = true;
            }else if(item=='+'||item=='-'||item=='*'||item=='/'){
                if(isNumber){
                    nums.add(temp);
                    isNumber=false;
                    temp=0;
                }
                tokens.add(item+"");
            }else if(item==' '){
                if(isNumber){
                    nums.add(temp);
                    isNumber = false;
                    temp=0;
                }
            }
        }
        if(isNumber){
            nums.add(temp);
            isNumber = false;
            temp=0;
        }

        //here we have tokens and then we need to use stack to process the calculator
        //First, * and / will be handled
        //then, we process + and -
        var stack = new ArrayList<Integer>();
        var itor = nums.iterator();
        stack.add(itor.next());
        for (String op: tokens){
            if(op.equals("*")){
                var t1 = stack.remove(stack.size()-1);
                var t2 = itor.next();
                stack.add(t1*t2);
                continue;
            }
            if(op.equals("/")){
                var t1 = stack.remove(stack.size()-1);
                var t2 = itor.next();
                stack.add(t1/t2);
                continue;
            }
            stack.add(itor.next());
        }
        int res = stack.get(0);
        int i = 1;
        for (String op : tokens) {
            if(op.equals("+")){
                res += stack.get(i++); 
                continue;
            }
            if(op.equals("-")){
                res -= stack.get(i++);
                continue;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        var o = new CalculateTwo();
        System.out.println( o.calculate("0-2147483647"));
        System.out.println( o.calculate(" 3/ 2 "));
        System.out.println( o.calculate("3+ 2 * 2"));
        System.out.println( o.calculate("1 + 1 - 1"));
    }
}