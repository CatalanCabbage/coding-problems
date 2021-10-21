/**
 * @author Davis Jeffrey
 */
package patterns.binary_search;

/**
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

public class FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int leftStart = binarySearch(nums, target, false);
        if (leftStart == -1) {
            return new int[]{-1, -1};
        }
        int rightStart = binarySearch(nums, target, true);
        return new int[]{leftStart, rightStart};
    }

    private int binarySearch(int[] nums, int target, boolean findMax) {
        int lo = 0;
        int hi = nums.length - 1;
        int index = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            //Mid is in our target. So there's a min/max.
            if (target == nums[mid]) {
                index = mid;
                if (findMax) {
                    //max needs to be found. We know hi > target as of now
                    //Keep increasing lo till we push mid to the right edge
                    lo = mid + 1;
                } else {
                    //Same as above
                    hi = mid - 1;
                }
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FirstAndLastPosition firstAndLastPosition = new FirstAndLastPosition();
        int[] result = firstAndLastPosition.searchRange(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(result[0] + ", " + result[1]);
    }
}
