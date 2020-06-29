package course;

import java.util.HashMap;

public class IsIsomorphic{

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        var map = new HashMap<Character,Character>();
        var s1 = s.toCharArray();
        var s2 = t.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            if(map.containsKey(s1[i])){
                if(map.get(s1[i])!=s2[i]){
                    return false;
                }
            }else{
                if(map.containsValue(s2[i])){
                    return false;
                }
                map.put(s1[i], s2[i]);
            }
        }
        return true;
    }

}