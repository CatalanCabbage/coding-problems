/**
 * @author Davis Jeffrey
 */
package patterns.dp;

/**
 * Given the weights and profits of ‘N’ items,
 * we are asked to put these items in a knapsack that has a capacity ‘C’.
 * Find the maximum profit from the items in the knapsack.
 *
 * We are allowed to use an unlimited quantity of an item.
 *
 * Eg: Items: { i1, i2, i3 }
 * Weights: { 1, 2, 3 }
 * Profits: { 15, 20, 50 }
 * Knapsack capacity: 5
 *
 * Solution: 80.
 * 2x(i1) + 1x(i3) == weight 5, profit 80
 */

public class FruitsKnapsack {
    private int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] db = new Integer[profits.length][capacity + 1]; //Current item and capacity
        int maxProfit = getMaxProfit(0, profits, weights, capacity, db);
        return maxProfit == Integer.MIN_VALUE ? -1 : maxProfit;
    }

    private int getMaxProfit(int currentItem, int[] profits, int[] weights, int capacity, Integer[][] db) {
        //What are the base cases?
        //1. If currentItem >= profits.length, return min_value
        //2. If weight == capacity, return profit
        //
        //What other return case is present?
        //In case we choose he currentItem, add the profit and return

        if (currentItem >= profits.length) {
            return Integer.MIN_VALUE;
        }
        if (capacity == weights[currentItem]) {
            return profits[currentItem];
        }
        if (db[currentItem][capacity] == null) {
            //Take current item
            int profitWithCurrent = Integer.MIN_VALUE;
            if (capacity >= weights[currentItem]) {
                profitWithCurrent = profits[currentItem] + getMaxProfit(currentItem, profits, weights, capacity - weights[currentItem], db);
            }

            int profitWithoutCurrent = getMaxProfit(currentItem + 1, profits, weights, capacity, db);
            db[currentItem][capacity] = Math.max(profitWithCurrent, profitWithoutCurrent);
        }

        return db[currentItem][capacity];
    }

    public static void main(String[] args) {
        FruitsKnapsack ks = new FruitsKnapsack();
        int[] profits = { 15, 20, 50 };
        int[] weights = { 1, 2, 3 };
        int maxProfit = ks.solveKnapsack(profits, weights, 5);
        System.out.println("Testcase passed? " + (maxProfit == 80) + ", got " + maxProfit);
    }
}
