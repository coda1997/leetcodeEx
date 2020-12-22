package leetCode;

public class Ex714 {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sold=0;
        int temp;
        for (int i = 1; i < prices.length; i++) {
            var item = prices[i];
            temp = buy;
            buy = Math.max(sold-prices[i], buy);
            sold = Math.max(sold, temp+prices[i]-fee);
        }
        return sold;
    }

    public static void main(String[] args) {
        var o = new Ex714();
        System.out.println(o.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
