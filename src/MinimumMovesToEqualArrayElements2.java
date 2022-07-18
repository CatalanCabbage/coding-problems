import java.util.Arrays;

/**
 * Problem:
 * Given an integer array nums of size n, return the minimum number of moves
 * required to make all array elements equal.
 *
 * In one move, you can increment or decrement an element of the array by 1.
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 *
 * Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 *
 * Times: 1
 * Rating: 2
 */

class MinimumMovesToEqualArrayElements2 {
    //https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/2216211/Median-better-than-average!-Developing-intution
    //https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/2215782/Visual-Explanation-%2B-Interview-Tips-or-JAVA
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int target = 0;
        if (len % 2 == 0) {
            target = (nums[(len / 2) - 1] + nums[len / 2]) / 2;
        } else {
            target = nums[len / 2];
        }
        int minMoves = 0;
        for (int num : nums) {
            minMoves += Math.abs(target - num);
        }
        return minMoves;
    }
}
