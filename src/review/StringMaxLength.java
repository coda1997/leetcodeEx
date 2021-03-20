package review;

import java.util.HashMap;
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
                //here arr[l]==t; that means we find the pre number equal to t;
                //thus, l should plus one to exclude the number;
                //table.remove(arr[l]);
                l++;
            }
            res = Math.max(res, r-l+1);
            table.add(arr[r]);
        }
        return res;
    }
    public int maxLength2(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        for (int r = 0; r < arr.length; r++) {
            if (map.containsKey(arr[r])){
                l = Math.max(l, map.get(arr[r])+1);
            }
            res = Math.max(res, r - l + 1);
            map.put(arr[r], r);
        }
        return res;
    }
}
