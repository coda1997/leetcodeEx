package leetCode;

public class Ex122 {
    public int maxProfit(int[] prices) {
        if(prices.length<1){
            return 0;
        }
        int dp1,dp2;
        dp1 = 0;
        dp2 = -prices[0];
        int t1, t2;
        for (int i = 1; i < prices.length; i++) {
            t1 = Math.max(dp1, dp2+prices[i]);
            t2 = Math.max(dp1-prices[i], dp2);
            dp1 = t1;
            dp2 = t2;
        }
        return dp1;
    }
}
