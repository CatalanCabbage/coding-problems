/**
 * Problem:
 * Given a list of integers nums, find the first missing positive integer. In other words, find the lowest positive integer that does not exist in the list.
 * The list can contain duplicates and negative numbers as well.
 * Link: https://binarysearch.com/problems/First-Missing-Positive
 */

import java.util.Arrays;

//Just sort and iterate, too easy.
class FirstMissingPositive {
    public int FirstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int currentNum = 1;
        for (int i = 0; i < nums.length; i++) {
            //Can do a binary search here to arrive at 1
            if (nums[i] <= 0) {
                continue;
            }
            //This means it's a repeated number
            if (nums[i] < currentNum) {
                continue;
            } else if (nums[i] == currentNum) {
                currentNum++;
            }
        }
        return currentNum;
    }
}
