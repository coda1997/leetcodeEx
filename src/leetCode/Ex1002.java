package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ex1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        var res = new HashMap<String, List<String>>();
        for (String str :
                strs) {
            int[] t = new int[26];
            for (var c :
                    str.toCharArray()) {
                t[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (t[i]>0){
                    sb.append(((char)(i+'a')));
                    sb.append(t[i]);
                }
            }
            var key = sb.toString();
            var l = res.getOrDefault(key, new ArrayList<>());
            l.add(str);
            res.put(key, l);
        }
        return List.copyOf(res.values());
    }
}
