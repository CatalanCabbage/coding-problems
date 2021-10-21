/**
 * @author Davis Jeffrey
 */
package patterns.binary_search;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Link: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

//Find the half that's sorted, keep or leave that half, repeat.
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[lo] <= nums[mid]) {
                //Means lo -> mid is sorted, so make a decision based on the left half alone.
                if (target >= nums[lo] && target <= nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { //nums[hi] > nums[mid]
                //Means mid -> hi is sorted
                if (target >= nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
