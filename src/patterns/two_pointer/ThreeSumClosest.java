/**
 * @author Davis Jeffrey
 */
package patterns.two_pointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums,
 * such that the sum is closest to target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * Link: https://leetcode.com/problems/3sum-closest/
 *
 * Take the most suitable metric to model the problem! Here, diff is our aim, so take diff instead of sum.
 */

public class ThreeSumClosest {
    int smallestDiff = Integer.MAX_VALUE; //Math.abs(Target - sum)
    int target;
    public int threeSumClosest(int[] nums, int target) {
        this.target = target;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            twoSum(i, nums);
        }
        return target - smallestDiff;
    }

    private void twoSum(int n, int[] nums) {
        int p1 = n + 1;
        int p2 = nums.length - 1;

        while (p1 < p2) {
            int diff = target - nums[n] - nums[p1] - nums[p2];
            //Can short circuit the whole problem here
            if (diff == 0) {
                smallestDiff = diff;
                return;
            }

            if (Math.abs(diff) < Math.abs(smallestDiff)) {
                smallestDiff = diff;
            }

            //Aim is to reduce diff to 0; here, increase in p1 == increase in sum == decrease in diff
            if (diff > 0) {
                p1++;
            } else {
                p2--;
            }
        }
    }

    /*
    int solution;
    int target;
    public int threeSumClosest(int[] nums, int target) {
        this.solution = nums[0] + nums[1] + nums[2];
        this.target = target;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //Prevent duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            twoSum(i, nums);
        }
        return solution;
    }

    private void twoSum(int n, int[] nums) {
        int p1 = n + 1;
        int p2 = nums.length - 1;

        while (p1 < p2) {
            int currNum = nums[n];
            int p1Num = nums[p1];
            int p2Num = nums[p2];
            int sum = currNum + p1Num + p2Num;
            if (Math.abs(target - sum) == 0) {
                solution = sum;
                return;
            }

            if (Math.abs(target - sum) < Math.abs(target - solution)) {
                solution = sum;
            }

            //Increase p1 when sum is less than target.
            if (sum < target) {
                p1++;
            } else {
                p2--;
            }
        }
    }
    */
}
