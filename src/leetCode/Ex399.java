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

    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int indexs = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            if (!map.containsKey(equations.get(i).get(0))) {
                map.put(equations.get(i).get(0), indexs++);
            }
            if (!map.containsKey(equations.get(i).get(1))) {
                map.put(equations.get(i).get(1), indexs++);
            }

        }
        FindJoin findJoin = new FindJoin(indexs);
        for (int i = 0; i < values.length; i++) {
            int ia = map.get(equations.get(i).get(0));
            int ib = map.get(equations.get(i).get(1));
            findJoin.union(ia, ib, values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            List<String> item = queries.get(i);
            int ia = map.getOrDefault(item.get(0), -1);
            int ib = map.getOrDefault(item.get(1), -1);
            if (ia == -1 || ib == -1) {
                res[i] = -1;
            }else{
                res[i] = findJoin.findUnion(ia, ib);
            }
        }

        return res;
    }

    class FindJoin{
        int[] parents;
        double[] weights;
        FindJoin(int n){
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            weights = new double[n];
            Arrays.fill(weights, 1.0);
        }


        int find(int index){
            if (parents[index] != index) {
                int origin = parents[index];
                parents[index] = find(parents[index]);
                weights[index] *= weights[origin];
            }
            return parents[index];
        }
        //note it is from i to j, not from j to i
        void union(int i, int j, double value){
            int pi = find(i);
            int pj = find(j);
            if (pi == pj) {
                return;
            }
            parents[pi] = pj;
            weights[pi] = value*weights[j]/weights[i];
        }

        double findUnion(int i, int j){
            int pi = find(i);
            int pj = find(j);
            if (pi != pj) {
                return -1.0;
            }else {
                return weights[i]/weights[j];
            }
        }
    }
}
