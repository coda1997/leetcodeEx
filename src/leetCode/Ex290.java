package leetCode;

import java.util.HashMap;
import java.util.HashSet;

public class Ex290 {
    public boolean wordPattern(String pattern, String str) {
        var map = new HashMap<Character, String>();
        var set = new HashSet<String>();
        var ss = str.split(" ");
        var cc = pattern.toCharArray();
        if (cc.length != ss.length) {
            return false;
        }
        for (int i = 0; i < cc.length; i++) {
            var item = cc[i];
            if (map.containsKey(item)) {
                if (!map.get(item).equals(ss[i])) {
                    return false;
                }
            } else {
                if (set.contains(ss[i])) {
                    return false;
                }
                map.put(item, ss[i]);
                set.add(ss[i]);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        var o = new Ex290();
        System.out.println(o.wordPattern("abba", "dog cat cat dog"));
        System.out.println(o.wordPattern("aabb", "dog cat cat dog"));
        System.out.println(o.wordPattern("abba", "dog dog dog dog"));
        System.out.println(o.wordPattern("aaaa", "dog dog dog dog"));
    }
}