/**
 * @author Davis Jeffrey
 */
package patterns.subsets;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Link: https://leetcode.com/problems/subsets-ii/
 */

public class Subsets2 {
    //Ref: https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    private List<List<Integer>> solution = new LinkedList<>();
    private int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        backtrack(new LinkedList<Integer>(), 0);
        return solution;
    }

    private void backtrack(LinkedList<Integer> tempList, int currentIndex) {
        solution.add(new LinkedList<>(tempList));
        for (int i = currentIndex; i < nums.length; i++) {
            //Needs to be i > currentIndex and not i > 0, so that the first time loop runs continue doesn't happen
            if (i > currentIndex && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            backtrack(tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
