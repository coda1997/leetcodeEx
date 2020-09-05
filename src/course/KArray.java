package course;

import java.util.HashSet;
import java.util.Set;

public class KArray {
    private Set<Integer> set;
    int len;
    public String getPermutation(int n, int k) {
        set = new HashSet<>();
        len = n;
        return helper(n, k);
    }

    private String helper(int n, int k){
        if(n==1){
            for(int i = 1;i<=len;i++){
                if(!set.contains(i)){
                    return i+"";
                }
            }
        }
        var od = order(n-1);
        int temp = 0;
        while(k>od*temp){
            temp++;
        }
        var kk = k-od*(temp-1);
        for(int i = 1;i<=temp;i++){
            if(set.contains(i)){
                temp++;
            }
        }
        set.add(temp);
        return temp+helper(n-1, kk);
    }

    private int order(int n){
        var res = 1;
        while(n>1){
            res *= n--;
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new KArray();
        System.out.println( o.getPermutation(3, 2));
    }
}
