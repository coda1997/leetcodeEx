package leetCode;

import java.util.Arrays;

public class Ex123 {
    public int maxProfit(int[] prices) {
        if (prices.length<2){
            return 0;
        }
        int[][] buy = new int[3][prices.length];
        int[][] sell = new int[3][prices.length];
        buy[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[0][i] = Math.max(buy[0][i-1], -prices[i]);
        }
        sell[1][0] = buy[1][0] = Integer.MIN_VALUE/2;
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < prices.length; j++) {
                buy[i][j] = Math.max(buy[i][j-1], sell[i][j-1]-prices[j]);
                sell[i][j] = Math.max(sell[i][j-1], buy[i-1][j-1]+prices[j]);
            }
        }
        return Math.max(Math.max(sell[1][prices.length - 1], sell[2][prices.length - 1]), 0);
    }

    public static void main(String[] args) {
        var o = new Ex123();
        System.out.println(o.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(o.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(o.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(o.maxProfit(new int[]{1}));
        System.out.println(o.maxProfit(new int[]{}));


    }
}
