/**
 * Problem:
 * A wiggle sequence is a sequence where the differences between successive numbers
 * strictly alternate between positive and negative.
 * The first difference (if one exists) may be either positive or negative.
 * A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.
 * For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3)
 * alternate between positive and negative.
 * In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences.
 * The first is not because its first two differences are positive, and the second is not because
 * its last difference is zero.
 *
 * A subsequence is obtained by deleting some elements (possibly zero) from the original sequence,
 * leaving the remaining elements in their original order.
 *
 * Given an integer array nums, return the length of the longest wiggle subsequence of nums.
 *
 * Link: https://leetcode.com/problems/wiggle-subsequence/
 */

class WiggleSubsequence {
    int maxLength = 0;
    public int wiggleMaxLengthDP(int[] nums) {
        //What are the possible cases for each number?
        //nums[i] < nums[i - 1] : Going down
        //nums[i] > nums[i - 1] : Going up
        //nums[i] = nums[i - 1] : Doesn't contribute

        //Alright, say this number is going up. What's the length till now?
        //length = 1 (current element) + max length ending down till (i - 1)
        //If current element is going down:
        //length = 1 (current element) + max length ending up till (i - 1)

        int[] up = new int[nums.length];
        int[] down = new int[nums.length];

        //Since first element can be counted in both increasing and decreasing sequence
        up[0] = 1;
        down[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                //Decreasing sequence
                down[i] = 1 + up[i - 1];
                up[i] = up[i - 1];
            } else if (nums[i] > nums[i - 1]) {
                //Increasing sequence
                up[i] = 1 + down[i - 1];
                down[i] = down[i - 1];
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return Math.max(up[nums.length - 1], down[nums.length - 1]);
    }

    //Note: This can be made even cleaner by moving prevNum = nums[i]; outside and chaining conditions.
    public int wiggleMaxLength(int[] nums) {
        //Keep travelling along the array. If you find a sign change, count it.
        int maxLen = 1;
        int prevNum = nums[0];
        Boolean isUp = null;
        int currentDirection = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < prevNum) {
                //Going down
                prevNum = nums[i];
                if (currentDirection != -1) {
                    maxLen++;
                    currentDirection = -1;
                }
            } else if (nums[i] > prevNum) {
                //Going up
                prevNum = nums[i];
                if (currentDirection != 1) {
                    maxLen++;
                    currentDirection = 1;
                }
            } else {
                //Same as prev number, do nothing
            }
            prevNum = nums[i];
        }
        return maxLen;

    }
}
