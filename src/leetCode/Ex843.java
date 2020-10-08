package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Master{
    public int guess(String word);
}

public class Ex843 {
    public void findSecretWord(String[] wordlist, Master master) {
        List<String> set = new ArrayList<>();
        for (String string : wordlist) {
            set.add(string);
        }
        int i = 0;
        while(i<10&&!set.isEmpty()){
            var cur = getGuess(set);
            var v= master.guess(cur);
            if(v==6){
                return;
            }
            i++;
            var temp = new ArrayList<String>();
            for (String string : set) {
                if(match(string, cur)==v){
                    temp.add(string);
                }
            }
            set = temp;
        }
    }
    private String getGuess(List<String> ll){
        if(ll.size()<2){
            return ll.get(0);
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < ll.size()-1; i++) {
            var w1 = ll.get(i);
            for (int j = i+1; j < ll.size(); j++) {
                var w2 = ll.get(j);
                var d = dis(w1, w2);
                map.put(w1, map.getOrDefault(w1, 0)+d);
                map.put(w2, map.getOrDefault(w2, 0)+d);
            }
        }
        int min = Integer.MAX_VALUE;
        String res = null;
        for (String key:ll) {
            if(min>map.get(key)){
                min = map.get(key);
                res = key;
            }
        }
        return res;
    }

    private int dis(String w1, String w2){
        int t = match(w1, w2);
        return t==-1?6:6-t;
    }

    private int match(String w1, String w2){
        int res = 0;
        var c1 = w1.toCharArray();
        var c2 = w2.toCharArray();
        for (int i = 0; i < c2.length; i++) {
            if(c1[i]==c2[i]){
                res++;
            }
        }
        return res==0?-1:res;
    }
}
