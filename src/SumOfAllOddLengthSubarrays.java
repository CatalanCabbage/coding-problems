import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Problem:
 * Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.
 * A subarray is a contiguous subsequence of the array.
 *
 * Link: https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 */


class SumOfAllOddLengthSubarrays {
    public int sumOddLengthSubarraysMathy(int[] arr) {
        int sum = 0;
        //Number of subarrays that involve this index i
        // = (subarrays ending at i) * (subarrays starting at i)
        //This is since these can be mixed and matched to get any subarray involving i.

        for (int i = 0; i < arr.length; i++) {
            //[1,2,3]
            //1: 1 * 3 = 3; 3 / 2 = 1; Note that this needs to be 2 ([1], [1,2,3])
            //2: 2 * 2 = 4; 4 / 2 = 2; This is correct
            //3: 3 * 1 = 3; 3 / 2 = 1; Note that this needs to be 2 ([3], [1,2,3])
            //When dividing, this rounds down the value when we actually need it to round up.
            //Hence, instead of oddSubarrays = totalSubarrays / 2, we do (totalSubarrays + 1) / 2;
            int arraysStartingHere = arr.length - i;
            int arraysEndingHere = i + 1;
            int totalSubarrays = arraysStartingHere * arraysEndingHere;
            int oddSubarrays = (totalSubarrays + 1) / 2;
            sum += oddSubarrays * arr[i];
        }
        return sum;
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int windowSize = 1; windowSize <= arr.length; windowSize += 2) {
            //Init window sum
            int windowSum = 0;
            for (int i = 0; i < windowSize; i++) {
                windowSum += arr[i];
            }

            //Remove right, include left
            int right = windowSize - 1;
            int left = 0;
            System.out.println("For size: " + windowSize);
            while (right < arr.length) {
                System.out.println(windowSum);
                sum += windowSum;
                System.out.println(arr[left]);
                System.out.println(arr[right]);
                windowSum -= arr[left];
                left++;
                right++;
                if (right < arr.length) {
                    windowSum += arr[right];
                }
            }
        }
        return sum;
    }

    @Test
    @DisplayName("Testcase 1")
    void isValid1() {
        SumOfAllOddLengthSubarrays sum = new SumOfAllOddLengthSubarrays();
        Assertions.assertEquals(sum.sumOddLengthSubarrays(new int[]{1,4,2,5,3}), 58) ;
    }
}
