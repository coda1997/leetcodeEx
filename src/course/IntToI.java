package course;

import java.util.regex.Pattern;

public class IntToI {
    public int myAtoi(String str) {
        var pattern = Pattern.compile("^[ ]*[+-]?[\\d]+");
        var matcher = pattern.matcher(str);
        if(!matcher.find()){
            return 0;
        }
        var s = matcher.group(0).toCharArray();
        var isNe = false;
        int res = 0;
        for (char c : s) {
            if(c==' '||c=='+'){
                continue;
            }
            if(c=='-'){
                isNe = true;
                continue;
            }
            int temp = c-'0';
            if(res > Integer.MAX_VALUE/10||res*10>Integer.MAX_VALUE-temp){
                if(isNe){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
            res *=10;
            res +=temp;
        }
        if(isNe){
            res = -res;
        }
        return res;
        
    }
    public static void main(String[] args) {
        var c = new IntToI();
        System.out.println(c.myAtoi("    -42"));
        System.out.println(c.myAtoi("4193 with words"));
        System.out.println(c.myAtoi("words and 987"));
        System.out.println(c.myAtoi("-91283472332"));
        System.out.println(c.myAtoi("+"));
        System.out.println(c.myAtoi("+5"));
        System.out.println(c.myAtoi("+-5+-"));
        System.out.println(c.myAtoi(""));
    }
}