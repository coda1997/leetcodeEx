package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Ex399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (var item :
                equations) {
            if (!map.containsKey(item.get(0))) {
                map.put(item.get(0), n++);
            }
            if (!map.containsKey(item.get(1))) {
                map.put(item.get(1), n++);
            }
        }
        //n mean the different number of symbols in equantions
        double[][] table = new double[n][n];
        for (var item :
                table) {
            Arrays.fill(item, -1);
        }
        //assignment
        for (int i = 0; i < values.length; i++) {
            int ia = map.get(equations.get(i).get(0));
            int ib = map.get(equations.get(i).get(1));
            table[ia][ib] = values[i];
            table[ib][ia] = 1 / values[i];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (table[i][k] > 0 && table[k][j] > 0) {
                        table[i][j] = table[i][k] * table[k][j];
                    }
                }
            }
        }
        //to get the res;
        int qLen = queries.size();
        double[] res = new double[qLen];
        for (int i = 0; i < qLen; i++) {
            var item = queries.get(i);
            int ia = map.getOrDefault(item.get(0),-1);
            int ib = map.getOrDefault(item.get(1), -1);
            if (ia < 0 || ib < 0) {
                res[i] = -1;
            } else {
                res[i] = table[ia][ib];
            }
        }
        return res;
    }
}
