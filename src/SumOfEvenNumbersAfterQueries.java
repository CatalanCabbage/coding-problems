import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Problem:
 * You are given an integer array nums and an array queries where queries[i] = [vali, indexi].
 *
 * For each query i, first, apply nums[indexi] = nums[indexi] + vali,
 * then print the sum of the even values of nums.
 *
 * Return an integer array answer where answer[i] is the answer to the ith query.
 * Link: https://leetcode.com/problems/sum-of-even-numbers-after-queries/
 */


class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] solution = new int[nums.length];

        //Take the sum of even values first
        int sumOfEvens = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                sumOfEvens += nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            int numBeforeAdding = nums[index];
            int numAfterAdding = nums[index] + val;

            //Actually add it
            nums[index] = numAfterAdding;

            //Magic
            if (numAfterAdding % 2 == 0) {
                //If query makes a number even:
                if (numBeforeAdding % 2 != 0) {
                    //If old number was odd: Add the number
                    sumOfEvens += numAfterAdding;
                } else {
                    //If old number was even: Add the diff
                    sumOfEvens += numAfterAdding - numBeforeAdding;
                }
            } else {
                //If query makes a number odd:
                if (numBeforeAdding % 2 != 0) {
                    //If old number was odd: do nothing
                } else {
                    //If old number was even: remove that number
                    sumOfEvens -= numBeforeAdding;
                }

            }
            solution[i] = sumOfEvens;
        }
        return solution;
    }
}
