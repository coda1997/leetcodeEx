package temp;

import java.util.HashMap;

public class Test {
    public void test(){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.get(1);
    }

    public int solution(int N) {
        // write your code in Java SE 8
        int pre = -1;
        int i = 0;
        int res = 0;
        while(N>0){
            if((N&1)==1){
                if(pre>=0){
                    res = Math.max(res, i-pre-1);
                }
                pre = i;
            }
            i++;
            N = N>>1;
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Test();
        System.out.println(o.solution(5));
    }
}
