/**
 * @author Davis Jeffrey
 */
package patterns.cyclic_sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Eg: Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 *
 * Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */

public class FindAllNumbersDisappearedInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNums = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
            } else {
                if (nums[nums[i] - 1] == nums[i]) {
                    i++;
                } else {
                    swap(nums, i, nums[i] - 1);
                }
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                missingNums.add(i + 1);
            }
        }
        return missingNums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
