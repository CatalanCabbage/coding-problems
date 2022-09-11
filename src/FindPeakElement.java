import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * Link: https://leetcode.com/problems/find-peak-element/
 */


class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return findPeakElement(nums, left, mid);
        }
        return findPeakElement(nums, mid + 1, right);
    }
}
