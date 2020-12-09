package leetCode;

public class Ex62 {
    public int uniquePaths(int m, int n) {
        long res = 1;
        for(int x = n,y=1;x<m+n-1;x++,y++){
            res = res*x/y;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        var o = new Ex62();
        System.out.println(o.uniquePaths(10, 10));
    }
}
