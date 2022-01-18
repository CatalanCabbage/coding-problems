/**
 * @author Davis Jeffrey
 */
package patterns.dp;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
 * Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 *
 * Eg: Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 */

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] costs) {
        int[] db = new int[costs.length + 1];
        return Math.min(getMinCost( 0, costs, db), getMinCost(1, costs, db));
    }

    private int getMinCost(int currentStep, int[] costs, int[] db) {
        if (currentStep >= costs.length) {
            return 0;
        }

        if (db[currentStep] == 0) {
            int costWithTwoSteps = costs[currentStep] + getMinCost(currentStep + 2, costs, db);
            int costWithOneStep = costs[currentStep] + getMinCost(currentStep + 1, costs, db);
            db[currentStep] = Math.min(costWithOneStep, costWithTwoSteps);
        }
        return db[currentStep];
    }
}
