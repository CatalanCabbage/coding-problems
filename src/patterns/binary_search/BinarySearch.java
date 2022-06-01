/**
 * @author Davis Jeffrey
 */
package patterns.binary_search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index.
 * Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Link: https://leetcode.com/problems/binary-search/
 */

public class BinarySearch {
    public int search(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
