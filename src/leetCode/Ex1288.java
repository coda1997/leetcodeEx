package leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class Ex1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals.length<2){
            return intervals.length;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o2[1] - o1[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });
        int res = 0;
        int[] temp = null;
        for (int i = 0; i < intervals.length; i++) {
            if (temp == null) {
                temp = intervals[i];
            }else{
                if (temp[0]<=intervals[i][0]&&intervals[i][1]<=temp[1]){

                }else{
                    res++;
                    temp = intervals[i];
                }
            }
        }

        return res+1;
    }
}
