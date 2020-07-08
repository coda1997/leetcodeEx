package course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WorldBreak {
    
    private int nMax = 0;
    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String string : wordDict) {
            nMax = Math.max(nMax, string.length());
        }
        return helper(s, 0, s.length(), wordDict);
    }

    private HashMap<Integer, List<String>> map = new HashMap<>();

    private List<String> helper(String s, int start, int end, List<String> worldDict){
        if(map.containsKey(start)){
            return map.get(start);
        }
        
        var res = new ArrayList<String>();
        if(start==end){
            res.add("");
            return res;
        }
        for (int i = start+1; i <=end&&i<=start+nMax; i++) {
            if(worldDict.contains(s.substring(start, i))){
                var resr = helper(s, i, end, worldDict);
                var tt = s.substring(start, i);
                for (String item : resr) {
                    res.add(tt+((item.length()==0)?"":" "+item));
                }
            }
        }
        map.put(start, res);
        return res;
    } 
    public static void main(String[] args) {
        var dict = new ArrayList<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        var o = new WorldBreak();

        System.out.println(o.wordBreak("catsanddog", dict));
    }
}