package patterns.sliding_window;
/**
 * Given an array of positive numbers and a positive number S:
 * Find the length of the smallest contiguous subarray whose sum is greater than or equal to S.
 * Return 0 if no such subarray exists.
 * <p>
 * Eg: Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2 //[5, 2]
 * <p>
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1 //[8]
 */

class SmallestSubarrayForSum {
    public static int findMinSubArray(int S, int[] arr) {
        int minSize = Integer.MAX_VALUE;
        int right = 0;
        int left = 0;
        int currentSum = 0;
        while (right < arr.length && left < arr.length) {
            //Each time, add an element on the right to the current sum
            currentSum += arr[right];
            right++;
            //Remove all left elements such that current sum is still >= our target
            //This will give us the smallest possible window
            while (left < right && currentSum - arr[left] >= S) {
                currentSum = currentSum - arr[left];
                left++;
            }
            if (right - left < minSize && currentSum >= S) {
                minSize = right - left;
            }
        }
        return minSize;
    }
}
