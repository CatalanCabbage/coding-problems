/**
 * @author Davis Jeffrey
 */
package patterns.two_pointer;

/**
 * Given an array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2,
 * where 1 <= answer[0] < answer[1] <= numbers.length.
 *
 * The tests are generated such that there is exactly one solution.
 * You may not use the same element twice.
 *
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;
        int[] solution = new int[2];

        while (p1 < p2) {
            int currentSum = numbers[p1] + numbers[p2];
            if (currentSum == target) {
                solution[0] = p1 + 1;
                solution[1] = p2 + 1;
                return solution;
            }
            if (currentSum < target) {
                p1++;
            } else {
                p2--;
            }
        }
        return solution;
    }
}
