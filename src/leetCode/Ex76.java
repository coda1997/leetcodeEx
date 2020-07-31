package leetCode;

import java.util.HashMap;

public class Ex76 {
    public String minWindow(String s, String t){
        var smap = new HashMap<Character, Integer>();
        var tmap = new HashMap<Character, Integer>();

        for (char c : t.toCharArray()) {
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        var ss = s.toCharArray();
        int l = 0;
        int r = 0;
        var res = "";
        var minLen = Integer.MAX_VALUE;
        while (r<ss.length){
            while (r<ss.length&&!check(smap, tmap)){
                var c = ss[r];
                r++;
                smap.put(c,smap.getOrDefault(c,0)+1);
            }
            //true and r is the right bond
            
            while (check(smap, tmap)){
                var c = ss[l];
                smap.put(c, smap.get(c)-1);
                l++;
            }
            if(l==0&&!check(smap, tmap)){
                return "";
            }
            if(r-(l-1)<minLen){
                minLen = r-(l-1);
                res = s.substring(l-1,r);
            }
        }
        return res;
    }
    private boolean check(HashMap<Character,Integer> smap, HashMap<Character, Integer> tmap){
        for (Character c : tmap.keySet()) {
            if(smap.getOrDefault(c,0)<tmap.get(c)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var o = new Ex76();
        System.out.println(o.minWindow("AAAAABC", "ABC"));
        System.out.println(o.minWindow("cabwefgewcwaefgcf", "cae"));
        System.out.println(o.minWindow("a", "b"));
        
    }
}
