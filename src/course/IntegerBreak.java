package course;
/**
 * IntegerBreak
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class IntegerBreak {
    
    int[] tp;
    public int integerBreak(int n) {
        tp = new int[n];
        int t = 0;
        tp[0] = 1;
        tp[1] = 2;
        for(int i = 1;i<=n/2;i++){
            int tt = helper(i)*helper(n-i);
            if(t<tt){
                t = tt;
            }
        }

        return t;
    }

    private int helper(int n){
        if(tp[n-1]!=0){
            return tp[n-1];
        }
        int res = n;
        for(int i = 1;i<=n/2;i++){
            int temp = helper(i)*helper(n-i);
            if(res<temp){
                res = temp;
            }
        }
        tp[n-1] = res;
        return res;
    }
}