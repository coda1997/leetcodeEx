package leetCode;

public class Ex1486 {
    public int xorOperation(int n, int start) {
        int s = start>>1;
        int e = n & start & 1;
        return (sumXor(s-1)^sumXor(s+n-1))<<1 +e;
    }

    private int sumXor(int n){
        int mod = n%4;
        if (mod==0){
            return n;
        }else if (mod==1){
            return 1;
        }else if (mod==2){
            return n+1;
        }else{
            return 0;
        }
    }
}
