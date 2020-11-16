package leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Ex406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                if(p1[0]!=p2[0]){
                    return p1[0] - p2[0];
                }else{
                    return p2[1] - p1[1];
                }
            }
        });

        int[][] res = new int[people.length][];
        for (int[] p : people) {
            int sp = p[1]+1;
            for(int i = 0;i<res.length;i++){
                if(res[i]==null){
                    sp--;
                }
                if(sp==0){
                    res[i] = p;
                    break;
                }
            }
        }
        return res;
    }
}
