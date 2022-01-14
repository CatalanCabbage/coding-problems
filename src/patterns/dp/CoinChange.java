/**
 * @author Davis Jeffrey
 */
package patterns.dp;

/**
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Link: https://leetcode.com/problems/coin-change
 *
 * There are 3 ways values returned are determined, need to get this intuition:
 * 1. If currentCoin > coins.length, it fails with Integer.MAX_VALUE
 * 2. If amountNeeded is 0, success - return 0
 * 3. Take currentCoin into account, find the minCoins for remainder, return that (minCoins + 1)
 */

public class CoinChange {
    static int minCoins = Integer.MAX_VALUE;
    static Integer[][] db;

    //Returns min coins needed
    private static int findMinCoins(int[] coins, int amountNeeded, int currentCoin) {
        if (currentCoin >= coins.length) {
            return Integer.MAX_VALUE;
        }
        if (amountNeeded == 0) {
            return 0;
        }
        if (db[currentCoin][amountNeeded] == null) {
            int minWithCoin = Integer.MAX_VALUE;
            if (amountNeeded >= coins[currentCoin]) {
                //Take this coin into account
                minWithCoin = findMinCoins(coins, amountNeeded - coins[currentCoin], currentCoin);

                //We add 1 to the result returned, since we actually added currentCoin before calling that method
                minWithCoin = (minWithCoin == Integer.MAX_VALUE) ? minWithCoin : minWithCoin + 1;
            }

            //Skip this coin
            int minWithoutCoin = findMinCoins(coins, amountNeeded, currentCoin + 1);
            db[currentCoin][amountNeeded] = Math.min(minWithCoin, minWithoutCoin);
        }

        return db[currentCoin][amountNeeded];
    }


    private static int coinChange(int[] coins, int amount) {
        db = new Integer[coins.length][amount + 1];
        int minCoins = findMinCoins(coins, amount, 0);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public static void main(String[] args) {
        int tc1 = coinChange(new int[]{1,2,5}, 11);
        int tc2 = coinChange(new int[]{2}, 3);
        System.out.println("Testcase 1: coins = {1,2,5}, amount = 11. Expected 3, got "
            + tc1);
        System.out.println("Testcase 2: coins = {2}, amount = 3. Expected -1, got "
            + tc2);
        System.out.println((tc1 == 3) + ", " + (tc2 == -1));
    }
}
