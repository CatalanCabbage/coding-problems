/**
 * @author Davis Jeffrey
 */
package patterns.cyclic_sort;

/**
 * Problem:
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 *
 * Eg: Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2
 * is the missing number in the range since it does not appear in nums.
 *
 * Link: https://leetcode.com/problems/missing-number/
 */

public class FirstMissingPositive {
    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i != nums[i] && nums[i] != nums.length) {
                swap(i, nums[i], nums);
            } else {
                i++;
            }
        }
        int missingNumber = nums.length;
        for (i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                missingNumber = i;
            }
        }
        return missingNumber;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
