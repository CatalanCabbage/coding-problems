/**
 * @author Davis Jeffrey
 */
package patterns.dp;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 *
 * Link: https://leetcode.com/problems/jump-game-ii
 *
 * Eg: Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */

public class JumpGame2 {
    public int jump(int[] nums) {
        Integer[] db = new Integer[nums.length]; //[Current position, steps remaining]
        return getMinJumps(0, nums, db);
    }

    private int getMinJumps(int currentPosition, int[] nums, Integer[] db) {
        if (currentPosition >= nums.length - 1) {
            return 0;
        }
        if (db[currentPosition] == null) {
            int minJumps = Integer.MAX_VALUE;
            //What's the min steps from current point?
            //Possibilities: 1 jump to nums[currentPosition] jumps
            for (int i = 1; i <= nums[currentPosition]; i++) {
                //Does it exceed max?
                if ((currentPosition + i) >= (nums.length)) {
                    break;
                }
                int altMinJumps = getMinJumps(currentPosition + i, nums, db);
                altMinJumps = altMinJumps == Integer.MAX_VALUE ? Integer.MAX_VALUE : altMinJumps + 1;

                minJumps = Math.min(minJumps, altMinJumps);
            }
            db[currentPosition] = minJumps;
        }
        return db[currentPosition];
    }
}
