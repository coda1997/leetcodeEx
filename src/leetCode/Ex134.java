package leetCode;

public class Ex134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0;
        int temp = 0;
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
            temp+=gas[i];
        }
        if (temp<0){
            return -1;
        }
        temp=0;
        for (int i = 0; i < gas.length; i++) {
            temp+=gas[i];
            if (temp<0){
                res=i+1;
                temp=0;
            }
        }

        return res;
    }
}
