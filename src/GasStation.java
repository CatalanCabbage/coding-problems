/**
 * Problem:
 * There are n gas stations along a circular route,
 * where the amount of gas at the ith station is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel
 * from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost,
 * return the starting gas station's index if you can travel around the circuit once in the
 * clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 *
 * Link: https://leetcode.com/problems/gas-station/
 *
 * Times: 1
 * Rating: 4
 */

class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int right = cost.length - 1;
        int left = 0;

        //Take end of array as right, the starting point.
        //Start of array is left, ending point.
        int currentGas = gas[right];
        int currentCost = cost[right];
        right--;

        while (right >= left) {
            //Can we do forward (from left) with the current gas?
            //If yes, go forward.
            //If no, we should have started at an earlier point that gives us more gas.
            if (currentGas >= currentCost) {
                currentGas += gas[left];
                currentCost += cost[left];
                left++;
            } else {
                currentGas += gas[right];
                currentCost += cost[right];
                right--;
            }
        }
        if (currentGas >= currentCost) {
            return right + 1;
        } else {
            return -1;
        }
    }
}
