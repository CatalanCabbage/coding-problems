/**
 * @author Davis Jeffrey
 */
package patterns.two_pointer;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
 * such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 *
 * Output:
 * If there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 *
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        while (p2 < nums.length) {
            nums[p1] = nums[p2];
            int currentNum = nums[p2];
            while (p2 < nums.length && currentNum == nums[p2]) {
                p2++;
            }
            p1++;
        }
        return p1;
    }
}
