package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex401 {
    List<String> res = new ArrayList<>();
    int h = 0, m = 0;
    public List<String> readBinaryWatch(int num) {
        helper(num, 0);
        return res;
    }

    private void helper(int num, int order){
        if((10-order)<num){
            return;
        }
        if(num==0){
            if(h>11||m>59){
                return;
            }
            if(m<10){
                res.add(String.format("%d:0%d", h,m));
            }else{
                res.add(String.format("%d:%d", h,m));
            }
            return;
        }
        helper(num, order+1);
        if(order<4){
            h ^= 1<<order;
            helper(num-1, order+1);
            h ^= 1<<order;
        }else {
            m ^= 1<<(order-4);
            helper(num-1, order+1);
            m ^= 1<<(order-4);
        }
    }

    public static void main(String[] args) {
        var o = new Ex401();
        var res = o.readBinaryWatch(1);
        for (String string : res) {
            System.out.println(string);
        }
    }
}