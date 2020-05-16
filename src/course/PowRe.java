package course;

import java.util.HashMap;
import java.util.Map;

public class PowRe {
    private Map<Integer, Double> map = new HashMap<>();
    
    public double myPow(double x, int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n==0){
            map.put(0, 1.0);
            return 1;
        }
        if(n==1){
            map.put(1, x);
            return x;
        }
        if(n==2){
            map.put(2, x*x);
            return x*x;
        }
        if(n<0){
            return myPow(1/x,-n);
        }
        var t = myPow(x,n/2)*myPow(x,n-n/2);
        map.put(n, t);
        
        return t;
    }
}