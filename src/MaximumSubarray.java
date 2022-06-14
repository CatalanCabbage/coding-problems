/**
 * Problem:
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 *
 * A subarray is a contiguous part of an array.
 *
 * Link: https://leetcode.com/problems/maximum-subarray/
 */


class MaximumSubarray {
    public int maxSubArray(int[] arr) {
        int maxSoFar = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar + arr[i], arr[i]);
            maxSum = Math.max(maxSum, maxSoFar);
        }

        return maxSum;
    }
}
