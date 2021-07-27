/**
 * @author Davis Jeffrey
 */
package patterns.two_pointer;

/**
 * Given an integer array nums, you need to find one continuous subarray
 * that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order.
 *
 *
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 * Link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //Find first mismatch from the left
        int left = 0;
        while (left < nums.length - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        //Already sorted
        if (left == nums.length - 1) {
            return 0;
        }

        //Find first mismatch from the right
        int right = nums.length - 1;
        while (right > 0 && nums[right - 1] <= nums[right]) {
            right--;
        }

        //Find the max and min in the subarray
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        //Stretch the subarray left till min's position is reached
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        //Stretch the subarray right till max's position is reached
        while (right < nums.length - 1 && nums[right + 1] < max) {
            right++;
        }

        return right - left + 1;
    }
}
