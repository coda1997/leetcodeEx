package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 */
public class Ex17 {

    private List<String> res = new ArrayList<>();
    private char[] temp;
    private char[][] table = new char[8][];

    public List<String> letterCombinations(String digits) {
        var cc = digits.toCharArray();
        if(cc.length==0){
            return res;
        }
        temp = new char[cc.length];
        table[0] = new char[]{'a','b','c'};
        table[1] = new char[]{'d','e','f'};
        table[2] = new char[]{'g','h','i'};
        table[3] = new char[]{'j','k','l'};
        table[4] = new char[]{'m','n','o'};
        table[5] = new char[]{'p','q','r','s'};
        table[6] = new char[]{'t','u','v'};
        table[7] = new char[]{'w','x','y','z'};
        
        helper(cc, 0);
        return res;
    }

    private void helper(char[] cc, int i){
        if(i==cc.length){
            res.add(new String(temp));
            return;
        }
        var t = table[cc[i]-'2'];
        for (char c : t) {
            temp[i] = c;
            helper(cc, i+1);
        }
    }

}