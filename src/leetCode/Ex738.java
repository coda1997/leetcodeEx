package leetCode;

public class Ex738 {
    public int monotoneIncreasingDigits(int N) {
        if(N<10){
            return N;
        }
        int mod= 1;
        while (mod<=N){
            mod*=10;
        }
        mod /=10;
        int t = N/mod;
        int tt = monotoneIncreasingDigits(N%mod);
        int ttt = tt/(mod/10);
        if(t<=ttt){
            return t*mod+tt;
        }else {
            return t*mod-1;
        }
    }

    public static void main(String[] args) {
        var o = new Ex738();
        System.out.println(o.monotoneIncreasingDigits(10));
        System.out.println(o.monotoneIncreasingDigits(1234));
        System.out.println(o.monotoneIncreasingDigits(332));
    }
}
