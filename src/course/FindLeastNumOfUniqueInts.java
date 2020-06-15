package course;

import java.util.HashMap;

public class FindLeastNumOfUniqueInts {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(var item: arr){
            map.put(item, map.getOrDefault(item, 0)+1);
        }
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(var key:map.keySet()){
            int kk = map.get(key);
            countMap.put(kk, countMap.getOrDefault(kk, 0)+1);
        }
        int i = 1;
        //count, num
        while(k>0){
            if(countMap.containsKey(i)){
                int c = countMap.get(i);
                if(k-i*c>=0){
                    countMap.put(i, 0);
                }else{
                    countMap.put(i, c-k/i);
                }
                k = k-i*c;
            }
            i++;
        }
        int res = 0;
        for(var key: countMap.keySet()){
            res += countMap.get(key);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println( new FindLeastNumOfUniqueInts().findLeastNumOfUniqueInts(new int[]{1,2,2,2,2}, 4));
    }
}