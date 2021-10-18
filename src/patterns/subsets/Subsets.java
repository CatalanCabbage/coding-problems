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

public class Subsets {

    //Solution: Put an empty list in solution list.
    //For each element, clone all existing lists and add current element.
    public List<List<Integer>> subsetsCloning(int[] nums) {
        List<List<Integer>> solution = new LinkedList<>();
        solution.add(new LinkedList<>());
        for (int i = 0; i < nums.length; i++) {
            int currentLength = solution.size();
            for (int j = 0; j < currentLength; j++) {
                List<Integer> list = solution.get(j);
                //Duplicate all old lists
                List<Integer> tempList = new LinkedList<>(list);

                //Add current element to each list
                tempList.add(nums[i]);
                solution.add(tempList);
            }
        }
        return solution;
    }

    public List<List<Integer>> subsetsBacktracking(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(list, new LinkedList<>(), nums, 0);
        System.out.println(list);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new LinkedList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = new int[]{1, 2, 3};
        subsets.subsetsBacktracking(nums);
    }
}
