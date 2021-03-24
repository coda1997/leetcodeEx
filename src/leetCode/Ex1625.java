package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Ex1625 {
    private Set<String> set;
    private String res;
    public String findLexSmallestString(String s, int a, int b) {
        set = new HashSet<>();
        if (s == null || s.length() < 1) {
            return s;
        }
        set.add(s);
        res = s;
        dfs(s,a, b);
        return res;
    }
    
    private void dfs(String s,int a, int b){
        var t1 = s.toCharArray();
        for (int i = 1; i < t1.length; i+=2) {
            t1[i] = (char)(((t1[i]-'0')+a)%10+'0');
        }
        String s1 = new String(t1);
        if (!set.contains(s1)) {
            set.add(s1);
            res = stringMax(s1, res);
            dfs(s1, a, b);
        }
        var t2 = s.toCharArray();
        for (int i = 0; i < t2.length; i++) {
            t2[(i+b)%t2.length] = s.charAt(i);
        }
        var s2 = new String(t2);
        if (!set.contains(s2)) {
            set.add(s2);
            res = stringMax(s2, res);
            dfs(s2, a, b);
        }
    }
    private String stringMax(String s1, String s2){
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i)>s2.charAt(i)){
                return s2;
            }else if (s1.charAt(i)<s2.charAt(i)){
                return s1;
            }
        }
        return s1;
    }

    public static void main(String[] args) {
        var o = new Ex1625();
        System.out.println(o.findLexSmallestString("5525", 9, 2));
    }
}
