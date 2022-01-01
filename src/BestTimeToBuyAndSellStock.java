/**
 * @author Davis Jeffrey
 */

/**
 * Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Statement: You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and
 * choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 *
 * Eg: Input: prices = [7,1,5,3,6,4] and Output: 5
 * Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *
 */


//Solution: For each price, check max. it can be sold for (ie., max price to the right).
//Brute force soln: Check max to the right each time = O(n)
//Better soln: Memoize max price to the right, such that finding max to right = O(1)
class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] maxFuturePrice = new int[prices.length];
        int maxProfit = 0;

        int currentMax = 0;
        //Memoize max price to the right, so that retrieval in next step becomes O(1)
        for (int i = prices.length - 1; i >= 0; i--) {
            currentMax = Math.max(currentMax, prices[i]);
            maxFuturePrice[i] = currentMax;
        }

        for (int i = 0; i < prices.length - 1; i++) {
            int currentProfit = maxFuturePrice[i + 1] - prices[i];
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }
}


