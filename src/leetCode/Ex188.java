package leetCode;

public class Ex188 {
    public int maxProfit(int k, int[] prices) {
        if(prices.length<2){
            return 0;
        }
        k = Math.min(k, prices.length/2);
        int[][] s1 = new int[k+1][prices.length];
        int[][] s2 = new int[k+1][prices.length];
        s1[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            s1[0][i] = Math.max(s1[0][i-1], -prices[i]);
        }

        for (int i = 1; i <= k; i++) {
            s1[i][0] = s2[i][0] = Integer.MIN_VALUE / 2;
            for (int j = 1; j < prices.length; j++) {
                s1[i][j] = Math.max(s1[i][j - 1], s2[i][j - 1] - prices[j]);
                s2[i][j] = Math.max(s1[i-1][j - 1] + prices[j], s2[i][j - 1]);
            }
        }
        int res = 0;
        for (int i = 0; i <=k; i++) {
            res = Math.max(res, s2[i][prices.length-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Ex188();
        System.out.println(o.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(o.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
