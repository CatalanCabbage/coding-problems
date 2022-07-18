import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * A subsequence is a sequence that can be derived from an array by deleting some
 * or no elements without changing the order of the remaining elements.
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 * Link: https://leetcode.com/problems/longest-increasing-subsequence/submissions/
 *
 * Times: 1
 * Rating: 3
 */

class LongestIncreasingSubsequence {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length];
        return lengthOfLIS(nums, 0, -1);
    }

    private int lengthOfLIS(int[] nums, int index, int prev) {
        if (index == nums.length) {
            return 0;
        }
        if (prev != -1 && dp[index][prev] != 0) return dp[index][prev];
        int withThis = 0;
        if (prev == -1 || nums[index] > nums[prev]) {
            withThis = 1 + lengthOfLIS(nums, index + 1, index);
        }
        int withoutThis = lengthOfLIS(nums, index + 1, prev);
        int res = Math.max(withThis, withoutThis);
        if (prev != -1) {
            dp[index][prev] = res;
        }
        return res;
    }
}
