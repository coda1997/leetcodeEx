package leetCode;

public class Ex121 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            res = Math.max(res, price - min);
        }

        return res;
    }

    private int maxProfitInRange(int[] prices, int start, int end) {
        if (start == end) {
            return 0;
        }
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

    public int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            res = Math.max(res, maxProfitInRange(prices, 0, i) + maxProfitInRange(prices, i, prices.length));
        }
        return res;
    }

}
