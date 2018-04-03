package leetCode;

public class Ex50 {
    public double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        if(n == -2147483648){
            if (x!=1.0&&x!=-1.0) return 0.0;
            else return 1.0;
        }
        if (n < 0) return 1 / myPow(x, -n);

        int[] base = new int[32];
        int t = n;
        int i = 0;
        while (t > 0 && i < 32) {
            base[i++] = t & 1;
            t = t >>> 1;
        }
        double temp = x;
        double res = 1.0;
        for (int j = 0; j < 32; j++) {
            if (base[j] == 1) {
                res *= temp;
            }
            temp = temp * temp;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Ex50().myPow(2, 10));
    }
}
