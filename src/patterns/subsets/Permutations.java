/**
 * @author Davis Jeffrey
 */
package patterns.subsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 *
 * Eg. Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 
 * Link: https://leetcode.com/problems/permutations/
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
