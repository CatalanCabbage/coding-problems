/**
 * @author Davis Jeffrey
 */
package patterns.subsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Link: https://leetcode.com/problems/subsets/
 */

public class Permutations {
    List<List<Integer>> solution = new LinkedList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        backtrack(new LinkedList<>());
        return solution;
    }

    private void backtrack(List<Integer> tempList) {
        if(tempList.size() == nums.length) {
            solution.add(new LinkedList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
