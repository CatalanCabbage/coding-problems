/**
 * @author Davis Jeffrey
 */
package patterns.cyclic_sort;

/**
 * Problem:
 * Given an unsorted integer array nums, return the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 * Eg: Input: nums = [1,2,0]
 * Output: 3
 *
 * Link: https://leetcode.com/problems/first-missing-positive/
 *
 * Intuition: Put all elements in their respective indices.
 * Since we need to find first positive, take the array as 1-indexed.
 * In the end, the first index that does not have the same value in that index is the missing number.
 */

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            //If number is not an index number, it means this is taking the place of some missing index number.
            //Skip this index. If actual number for this index is found later, it'll be swapped with this anyway.
            if (nums[i] < 1 || nums[i] > nums.length) {
                i++;
                continue;
            }
            //Number is in its place, move to next
            if (nums[i] == i + 1) {
                i++;
                continue;
            }
            //Put the number in its place, except:
            //Say num in index 1 is 2, but num in index 2 is also 2.
            //It means there's a duplicate, no point in swapping.
            if (nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
                continue;
            } else {
                i++;
            }
        }

        //Loop through to find first mismatch
        for (i = 0; i < nums.length; i++) {
            if (i < 0 || nums[i] != i + 1) {
                return i + 1;
            }
        }
        //If all numbers corresponding to indices are present, missing number should be length + 1
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
