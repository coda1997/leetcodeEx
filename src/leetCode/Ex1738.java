package leetCode;

import java.util.ArrayList;

public class Ex1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int[][] pres = new int[matrix.length+1][matrix[0].length+1];
        var retList = new ArrayList<Integer>();
        for (int i = 1; i < pres.length; i++) {
            for (int j = 1; j < pres[i].length; j++) {
                pres[i][j] = pres[i-1][j]^pres[i][j-1]^pres[i-1][j-1]^matrix[i-1][j-1];
                retList.add(pres[i][j]);
            }
        }
        retList.sort((o1, o2) -> o2-o1);
        return retList.get(k-1);
    }
}
