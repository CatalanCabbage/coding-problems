/**
 * @author Davis Jeffrey
 */
package patterns.two_pointer;

/**
 * Given an integer array nums sorted in ascending order,
 * return an array of the squares of each number sorted in ascending order.
 * The array can have negative numbers.
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Link: https://leetcode.com/problems/squares-of-a-sorted-array/
 */

public class SquaresSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] solution = new int[nums.length];

        int p1 = 0;
        int p2 = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int p1Square = nums[p1] * nums[p1];
            int p2Square = nums[p2] * nums[p2];
            if (p1Square > p2Square) {
                solution[i] = p1Square;
                p1++;
            } else {
                solution[i] = p2Square;
                p2--;
            }
        }
        return solution;
    }
}
