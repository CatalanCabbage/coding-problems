/**
 * @author Davis Jeffrey
 */

/**
 * Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * Statement: You are given an integer array prices,
 * where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock.
 * You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 *
 * Eg: Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 *
 */

class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        //Find next valley
        //Sell at next peak
        //$$$
        int maxProfit = 0;
        int buyingPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            //If less, this is a valley, set as buyingPrice
            //If greater than buyingPrice, this is a peak, sell and buy again
            if (prices[i] < buyingPrice) {
                buyingPrice = prices[i];
            } else {
                maxProfit += prices[i] - buyingPrice;
                buyingPrice = prices[i];
            }
        }

        return maxProfit;
    }
}


