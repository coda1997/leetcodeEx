package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Ex649 {
    public String predictPartyVictory(String senate) {
        int len = senate.length();
        Deque<Integer> rs = new LinkedList<>();
        Deque<Integer> ds = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char item = senate.charAt(i);
            if(item=='R'){
                rs.offer(i);
            }else{
                ds.offer(i);
            }
        }
        while (!rs.isEmpty()&&!ds.isEmpty()){
            var ri = rs.pop();
            var di = ds.pop();
            if(ri<di){
                rs.offer(ri + len);
            }else{
                ds.offer(di + len);
            }
        }
        return !rs.isEmpty()?"Radiant":"Dire";
    }
}
