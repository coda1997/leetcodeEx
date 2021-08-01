package leetCode;

import java.util.ArrayList;

public class Ex1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        var list = new ArrayList<int[]>();
        for (int i = 0; i < mat.length; i++) {
            int l = 0;
            int r = mat[i].length;
            int mid;
            while (l < r) {
                mid = (r-l)/2+l;
                if (mat[i][mid]==1){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }
            list.add(new int[]{l, i});
        }
        list.sort((o1, o2) -> {
            if (o1[0]==o2[0]){
                return o1[1]-o2[1];
            }else{
                return o1[0]-o2[0];
            }
        });
        var res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[1];
        }
        return res;
    }
}
