package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if(left>interval[1]){
                ansList.add(interval);
            }else if(right<interval[0]){
                if(!placed){
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            }else{
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if(!placed){
            ansList.add(new int[]{left, right});
        }
        int[][] res = new int[ansList.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = ansList.get(i);
        }
        return res;
    }


    public static void main(String[] args) {
        var o = new Ex57();
        var res = o.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
        for (int[] is : res) {
            System.out.println(Arrays.toString(is));
        }
    }
}
