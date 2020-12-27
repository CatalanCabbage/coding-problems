/**
 * @author Davis Jeffrey
 */

/**
 * Problem: https://leetcode.com/problems/arranging-coins/
 * Statement: You have a total of n coins that you want to form in a staircase shape,
 * where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        int coins = 2147483647;
        int rows = arrangingCoins.getRows(coins);
        System.out.println("Coins: " + coins + " Rows: " + rows);
    }

    private int getRows(int coins) {
        int sum = 0;
        int rows = 0;

        int coinsInRow = 1;
        while (sum < coins) {
            //Without this "or", sum+coinsInRow overflow occurs when coins == 2147483647
            if (sum + coinsInRow > coins || sum + coinsInRow < 0) {
                return rows;
            }
            sum = sum + coinsInRow;
            coinsInRow++;
            rows++;
        }
        return rows;
    }
}
