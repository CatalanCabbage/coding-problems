/**
 * @author Davis Jeffrey
 */

/**
 * Statement:
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day,
 * and an integer k.
 * Find the maximum profit you can achieve.
 * You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously
 * (i.e., you must sell the stock before you buy again).
 *
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */

//https://www.youtube.com/watch?v=2FROyvnnrrM
class BestTimeToBuyAndSellStock4 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0) {
            return 0;
        }
        //We can buy and sell everyday
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                //As long as there's an increase, we can profit
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int maxProfit = 0;
        int[][] dp = new int[prices.length][k + 1];
        //  p r i c e s
        //0 0 0 0 0 0 0
        //1 0 x x x x x
        //2 0

        //We don't need to set these 2, but still...
        //At 0 transactions, max is always 0
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = 0;
        }
        //For 1 day without the opportunity to sell stocks, max is always 0
        for (int i = 0; i < k; i++) {
            dp[0][i] = 0;
        }

        //For each possible number of transactions
        //Needs to be <= k to cover all transactions
        for (int i = 1; i <= k; i++) {
            //System.out.println("----------transactions: " + i);

            //For optimization of the m loop
            //int maxTillDay = -prices[0];

            //For each day
            for (int j = 1; j < prices.length; j++) {
                //It's possible to do nothing
                int doNothing = dp[j - 1][i];

                //Make a transaction, in which case this is (max till whichever day you bought this stock + profit from then)
                int transact = Integer.MIN_VALUE;

                //m = 0 since we can buy on 0th day
                for (int m = 0; m < j; m++) {
                    int maxTillDay = dp[m][i - 1];
                    int transactionProfit = prices[j] - prices[m];
                    //System.out.println("Today: " + j + ", bought day: " + m);
                    transact = Math.max(transact, maxTillDay + transactionProfit);
                }

                //The above loop can be optimized further: Right now we're going through the whole
                //row each time, checking the same values in each iteration. We can incrementally store values instead.
                // transact = prices[j] + maxTillDay;
                // maxTillDay = Math.max(maxTillDay, dp[j][i - 1] - prices[j]); //Update for next iteration


                int maxProfitForDay = Math.max(doNothing, transact);
                dp[j][i] = maxProfitForDay;
                //System.out.println("Profit: " + maxProfitForDay);
                maxProfit = Math.max(maxProfit, maxProfitForDay);
            }
        }
        return maxProfit;
    }






    Integer[][] dp;
    Integer[][] dp2;
    public int maxProfitHack(int transactions, int[] prices) {
        dp = new Integer[prices.length][transactions + 1];
        dp2 = new Integer[prices.length][transactions + 1];
        //Each day, we can either pick it or skip it
        return maxProfit(transactions, prices, 0, -1);
    }

    private int maxProfit(int transactions, int[] prices, int day, int stockBoughtOn) {
        //Overflow
        if (day >= prices.length) {
            return 0;
        }
        //No transactions remaining
        if (stockBoughtOn == -1 && transactions <= 0) {
            return 0;
        }

        //Already bought stock?
        if (stockBoughtOn != -1) {

            if (dp2[stockBoughtOn][transactions] != null) {
                return dp2[stockBoughtOn][transactions];
            }

            //Sell it now
            int profitNow = prices[day] - prices[stockBoughtOn] + maxProfit(transactions, prices, day, -1);

            //Sell it the next day
            int profitLater = maxProfit(transactions, prices, day + 1, stockBoughtOn);
            dp2[stockBoughtOn][transactions] = Math.max(profitNow, profitLater);
            return dp2[stockBoughtOn][transactions];
        } else {
            //Need to buy stock?

            if (dp[day][transactions] != null) {
                return dp[day][transactions];
            }

            //Buy stock today
            int profitNow = maxProfit(transactions - 1, prices, day + 1, day);

            //Buy it the next day
            int profitLater = maxProfit(transactions, prices, day + 1, -1);
            dp[day][transactions] = Math.max(profitNow, profitLater);
            return dp[day][transactions];
        }
    }
}


