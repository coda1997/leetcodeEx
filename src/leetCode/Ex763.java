package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex763 {
    public List<Integer> partitionLabels(String S) {
        var res = new ArrayList<Integer>();
        var ends = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            ends[S.charAt(i)-'a'] = i;
        }
        int start = 0;
        int end = -1;
        for (int i = 0; i < len; i++) {
            end = Math.max(end, ends[S.charAt(i)-'a']);
            if(end==i){
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res;
    }
}