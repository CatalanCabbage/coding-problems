/**
 * @author Davis Jeffrey
 */
package patterns.dp;

import java.util.Arrays;

/**
 * Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Link: https://leetcode.com/problems/partition-equal-subset-sum/
 *
 * Eg: Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = (Arrays.stream(nums).sum());
        int target = sum / 2;
        //In case sum comes to an odd number, a partition isn't possible since
        //it'll involve decimals but nums only has positive numbers
        if (target * 2 != sum) {
            return false;
        }

        Boolean[][] db = new Boolean[nums.length][target + 1];

        return isSumPresent(0, target, nums, db);
    }

    private boolean isSumPresent(int currentIndex, int target, int[] nums, Boolean[][] db) {
        if (currentIndex >= nums.length) {
            return false;
        }
        if (target == 0) {
            System.out.println(currentIndex);
            return true;
        }

        if (db[currentIndex][target] == null) {
            //Add current and move to the next
            boolean isSumPresentWithCurrent = false;
            if (nums[currentIndex] <= target) {
                isSumPresentWithCurrent = isSumPresent(currentIndex + 1, target - nums[currentIndex], nums, db);
            }

            //Skip current and move to the next
            boolean isSumPresentWithoutCurrent = isSumPresent(currentIndex + 1, target, nums, db);
            db[currentIndex][target] = isSumPresentWithCurrent || isSumPresentWithoutCurrent;
        }
        return db[currentIndex][target];
    }
}
