package leetCode;

import java.util.Arrays;

public class Ex205 {
    public boolean isIsomorphic(String s, String t) {
        char[] table = new char[127];
        boolean[] ts = new boolean[127];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            var c1 = s.charAt(i);
            var c2 = t.charAt(i);
            if (table[c1] == 0) {
                if(ts[c2]){
                    return false;
                }else{
                    table[c1] = c2;
                    ts[c2] = true;
                }
            }else if (table[c1] != c2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var o = new Ex205();
        System.out.println(o.isIsomorphic("egg", "add"));
        System.out.println(o.isIsomorphic("foo", "bar"));
        System.out.println(o.isIsomorphic("paper", "title"));
        System.out.println(o.isIsomorphic("ab", "aa"));

    }
}
