package leetCode;

import java.util.HashMap;

public class Ex621 {
    public int leastInterval(char[] tasks, int n) {
        var map = new HashMap<Character,Integer>();
        int maxV = Integer.MIN_VALUE;
        for (char c : tasks) {
            int t = map.getOrDefault(c, 0)+1;
            map.put(c, t );
            maxV = Math.max(maxV,t);
        }
        int mc = 0;
        for(char key: map.keySet()){
            if(map.get(key)==maxV){
                mc++;
            }
        }
        return Math.max(tasks.length, (maxV-1)*(n+1)+mc);
    }
}
