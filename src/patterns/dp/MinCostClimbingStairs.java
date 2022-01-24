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
    public int getMinCostRec(int[] costs) {
        int[] db = new int[costs.length + 1];
        return Math.min(getMinCost( 0, costs, db), getMinCost(1, costs, db));
    }

    //Top-down
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

    private int getMinCostIter(int[] costs) {
        int[] db = new int[costs.length];
        for (int i = 0; i < db.length; i++) {
            if (i < 2) {
                db[i] = costs[i];
            } else {
                db[i] = costs[i] + Math.min(db[i - 1], db[i - 2]);
            }
        }
        return Math.min(db[costs.length - 1], db[costs.length - 2]);
    }

    //Only the last 2 results are needed for us to calculate the next value.
    //Ditch the array
    private int getMinCostOptimizedIter(int[] costs) {
        int first = 0;
        int second = 1;
        for (int i = 0; i < costs.length; i++) {
            if (i < 2) {
                int temp = costs[i];
                second = first;
                first = temp;
            } else {
                int temp = costs[i] + Math.min(first, second);
                second = first;
                first = temp;
            }
        }
        return Math.min(first, second);
    }

    public static void main(String[] args) {
        int[] inp = new int[]{1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        System.out.println(minCostClimbingStairs.getMinCostRec(inp));
        System.out.println(minCostClimbingStairs.getMinCostIter(inp));
        System.out.println(minCostClimbingStairs.getMinCostOptimizedIter(inp));

    }
}
