/**
 * @author Davis Jeffrey
 */
package patterns.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Link: https://leetcode.com/problems/3sum/
 */

public class ThreeSum {
    List<List<Integer>> solnList = new LinkedList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) {
            return solnList;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            //Bug: Had initially tried nums[i + 1]
            //Input: [-1, -1, 2, ...]
            //nums[i + 1]: it skips the first -1, and we end up with no solution
            //nums[i - i]: we compute for the first -1, and then skip all -1s.
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            getTwoSum(i, nums);
        }
        return solnList;
    }

    private void getTwoSum(int n, int[] nums) {
        int p1 = n + 1;
        int p2 = nums.length - 1;
        int target = 0 - nums[n];
        while(p1 < p2) {
            int sum = nums[p1] + nums[p2];
            if (sum == target) {
                solnList.add(Arrays.asList(nums[n], nums[p1], nums[p2]));
                //So that we don't end up with duplicates
                while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                while (p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;
                p1++;
                p2--;
                //No break here - the same i can have solutions with multiple (j, k)
            } else if (sum < target) {
                p1++;
            } else {
                p2--;
            }
        }
    }
}
