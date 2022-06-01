import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Problem:
 * You are given an integer array nums and an integer goal.
 * You want to choose a subsequence of nums such that the sum of its elements is the closest possible to goal.
 * That is, if the sum of the subsequence's elements is sum,
 * then you want to minimize the absolute difference abs(sum - goal).
 *
 * Return the minimum possible value of abs(sum - goal).
 *
 * Note that a subsequence of an array is an array formed by removing some elements,
 * possibly all or none of the original array.
 *
 * Link: https://leetcode.com/problems/closest-subsequence-sum/
 *
 * Eg. Input: nums = [5,-7,3,5], goal = 6
 * Output: 0
 * Explanation: Choose the whole array as a subsequence, with a sum of 6.
 * This is equal to the goal, so the absolute difference is 0.
 */


class ClosestSubsequenceSum {
    //This isn't optimized enough to solve this problem.
    //See: https://en.wikipedia.org/wiki/Subset_sum_problem
    //https://leetcode.com/problems/closest-subsequence-sum/discuss/1053880/Is-it-possible-to-solve-this-problem-with-dp-memoization/843073
    int abs = Integer.MAX_VALUE;
    public int minAbsDifference(int[] nums, int goal) {
        minAbsDifference(nums, goal, 0, 0);
        return abs;
    }

    private void minAbsDifference(int[] nums, int goal, int currentPosition, int currentSum) {
        //Base case: Nums has ended
        if (currentPosition == nums.length) {
            abs = Math.min(abs, Math.abs(currentSum - goal));
            return;
        }
        //Case 1: Take this number
        minAbsDifference(nums, goal, currentPosition + 1, currentSum + nums[currentPosition]);
        //Case 2: Remove this number
        minAbsDifference(nums, goal, currentPosition + 1, currentSum);
    }
}
