package patterns.sliding_window;

/**
 * You are given an array of integers nums, there is a sliding window of size k,
 * which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max number in the sliding window.
 * <p>
 * Eg: Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7] (3 is highest in [1,3,-1], 3 is highest in [3,-1,3], etc)
 * <p>
 * Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */

class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int[] solution = new int[nums.length - k + 1];
        int currentIndex = 0;
        int currentMaxIndex = 0;
        int currentMax = Integer.MIN_VALUE;

        while (right < k) {
            if (nums[right] > currentMax) {
                currentMax = nums[right];
                currentMaxIndex = right;
            }
            right++;
        }
        nums[currentIndex] = currentMax;
        currentIndex++;

        while (right < nums.length) {
            if (left <= currentMaxIndex) {
                if (nums[right] < nums[currentMaxIndex]) {
                    solution[currentIndex] = nums[currentMaxIndex];
                } else {
                    //Check left

                    //Check left + 1
                }
            }
        }
        return solution;
    }
}
