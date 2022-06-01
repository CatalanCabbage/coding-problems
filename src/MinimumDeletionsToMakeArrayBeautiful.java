import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Problem:
 * You are given a 0-indexed integer array nums. The array nums is beautiful if:
 *
 * nums.length is even.
 * nums[i] != nums[i + 1] for all i % 2 == 0.
 *
 * Note that an empty array is considered beautiful.
 * You can delete any number of elements from nums.
 * When you delete an element, all the elements to the right of the deleted element
 * will be shifted one unit to the left to fill the gap created and
 * all the elements to the left of the deleted element will remain unchanged.
 *
 * Return the minimum number of elements to delete from nums to make it beautiful.
 *
 * Link: https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/
 */


class MinimumDeletionsToMakeArrayBeautiful {
    public int minDeletion(int[] nums) {
        int minDeletions = 0;
        boolean isEvenIndex = true;
        boolean isEvenArray = nums.length % 2 == 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (isEvenIndex && nums[i] == nums[i + 1]) {
                minDeletions++;
                isEvenArray = !isEvenArray;
                //If an index is deleted, next index will be in the same position as this.
                //No need to update isEvenindex
            } else {
                //Move to the next index
                isEvenIndex = !isEvenIndex;
            }
        }
        //If array is odd, one element needs to be removed.
        if (!isEvenArray) {
            minDeletions++;
        }
        return minDeletions;
    }

    @Test
    @DisplayName("Check if valid")
    void isValid() {
        assertEquals(minDeletion(new int[]{1,1,2,2,3,3}), 2);
        assertEquals(minDeletion(new int[]{0,6,6,1,8,7}), 0);
    }
}
