package leetCode;

import java.util.List;

public class Ex120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len==0){
            return 0;
        }
        if (len==1){
            return triangle.get(0).get(0);
        }
        int llen = triangle.get(len-1).size();
        int[] table = new int[llen];
        table[0]=triangle.get(0).get(0);
        for (int i = 1; i <len; i++) {
            int size = triangle.get(i).size();
            table[size -1]=table[size -2]+triangle.get(i).get(size-1);
            for (int j = size-2; j >0; j--) {
                table[j]=Math.min(table[j-1],table[j])+triangle.get(i).get(j);
            }
            table[0]+=triangle.get(i).get(0);
        }
        int min = table[0];
        for (int i : table) {
            min = i<min?i:min;
        }
        return min;
    }
}
