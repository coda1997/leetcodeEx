package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex89 {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int num = 1;
        for (int i = 0;i<n;i++) num*=2;
        res.add(0);
        for (int i = 1;i<num;i++){
            res.add((i >> 1) ^ i);

        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new Ex89().grayCode(2);
        for ( int n : res) {
            System.out.println(Integer.toBinaryString(n)+" "+n);
        }
    }
}
