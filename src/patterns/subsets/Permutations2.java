/**
 * @author Davis Jeffrey
 */
package patterns.subsets;

import java.util.LinkedList;
import java.util.List;

/**
 * GGiven a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 *
 *
 *
 * Eg. Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 
 * Link: https://leetcode.com/problems/permutations-ii/
 */

public class Permutations2 {
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
