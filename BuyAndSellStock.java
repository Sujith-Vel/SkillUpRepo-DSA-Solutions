package DSA.Random;

public class BuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min = prices[i];
            }
            profit = Math.max(prices[i] - min, profit);
        }
        return profit;
    }
}
