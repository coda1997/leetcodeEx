package leetCode;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int t = x^y;
        int c = 0;
        while(t>0){
            c++;
            t = t&(t-1);
        }
        return c;
    }
}