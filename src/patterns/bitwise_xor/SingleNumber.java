/**
 * @author Davis Jeffrey
 */
package patterns.bitwise_xor;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Link: https://leetcode.com/problems/single-number/
 * Intuition: XOR of a number itself = 0
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int missingNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            missingNumber = missingNumber ^ nums[i];
        }
        return missingNumber;
    }
}
