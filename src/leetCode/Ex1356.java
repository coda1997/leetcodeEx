package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex1356 {
    public int[] sortByBits(int[] arr) {
        int[] bitc = new int[10001];
        List<Integer> temp = new ArrayList<>(arr.length);
        for (int i = 0; i < bitc.length; i++) {
            bitc[i] = bitc[i>>1] + (i&1);
        }
        for (int i = 0; i < arr.length; i++) {
            temp.add(arr[i]);
        }
        Collections.sort(temp, new Comparator<Integer>(){
            public int compare(Integer x, Integer y){
                if(bitc[x]!=bitc[y]){
                    return bitc[x] - bitc[y];
                }else {
                    return x-y;
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp.get(i);
        }
        return arr;
    }
    
}
