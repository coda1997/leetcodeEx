package leetCode;

public class Ex134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for(int i = 0;i< len;i++){
            int g = 0;
            for(int j = i;j<len+i;j++){
                int index = j%len;
                g += gas[index];
                g -= cost[index];
                if(g<0){
                    break;
                }
            }
            if(g>=0){
                return i;
            }
        }
        return -1;
    }
}
