/**
 * Problem:
 * You are given a list of integers nums of length n representing the current score of swimmers in a competition.
 * There is one more round to swim and the first place winner for this round gets n points, second place n-1 points, etc. and the last place gets 1 point.
 * Return the number of swimmers that can still win the competition after the last round. If you tie for first in points, this still counts as winning.
 * <p>
 * Link: https://binarysearch.com/problems/Win-After-Last-Round
 * <p>
 * Solution:
 * 1. Find the lowest possible winning score (threshold).
 * 2. Count the number of people who can equal or exceed that threshold if placed first.
 */

import java.util.Arrays;

class WinAfterLastRound {
    public int solve(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int threshold = nums[0];
        //Find lowest winning score possible
        //ie., for input [1,2,3], lowest winning score is 4.
        //For lowest in the last round, give the highest points here and vice versa.
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++) {
            if ((nums[n - i] + i) > threshold) {
                threshold = (nums[n - i] + i);
            }
        }

        int possibleWinners = 0;
        //Count people who can match or exceed that score when placed first
        for (int i = 0; i < n; i++) {
            if ((nums[i] + n) >= threshold) {
                possibleWinners++;
            }
        }

        return possibleWinners;
    }
}
