/**
 * @author Davis Jeffrey
 */
package patterns.two_pointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place,
 * so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * Link: https://leetcode.com/problems/sort-colors/
 *
 * Solution: Maintain an invariant - left of p1 is all 0s, right of p2 is all 2s.
 * Move a third pointer from p1 to p2, redistributing 0s and 2s.
 */

public class SortColours {
    public void sortColors(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int i = 0;

        while (i <= p2) {
            if (nums[i] == 0) {
                swap(nums, i, p1);
                i++;
                p1++;
            } else if (nums[i] == 2) {
                swap(nums, i, p2);
                p2--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
