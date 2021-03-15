package review;

import java.util.HashSet;
import java.util.Set;

public class StringMaxLength {
    public int maxLength (int[] arr) {
        // write code here
        //mask or array
        if (arr.length<2){
            return arr.length;
        }
        Set<Integer> table = new HashSet<>();
        int l = 0;
        table.add(arr[l]);
        int res = 1;
        for (int r = 1; r < arr.length; r++) {
            if (table.contains(arr[r])){
                //count res, and shift l
                int t = arr[r];
                //table.add(arr[r]);
                while (arr[l]!=t){
                    table.remove(arr[l]);
                    l++;
                }
                //table.remove(arr[l]);
                l++;
            }
            res = Math.max(res, r-l+1);
            table.add(r);
        }
        return res;
    }
}
