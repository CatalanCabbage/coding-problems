package patterns.sliding_window;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * You are given an array of integers nums, there is a sliding window of size k,
 * which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max number in the sliding window.
 * <p>
 * Eg: Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7] (3 is highest in [1,3,-1], 3 is highest in [3,-1,3], etc)
 * <p>
 * Link: https://leetcode.com/problems/sliding-window-maximum/
 * //https://leetcode.com/problems/sliding-window-maximum/discuss/871317/Clear-thinking-process-with-PICTURE-brute-force-to-mono-deque-pythonjavajavascript
 */

class SlidingWindowMaximum {
    //nums = [1,3,0,-1,-3,5,3,2,1,6,7], k = 3
    //[3,3,5,5,6,7]
    //0 0 0 3
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] solution = new int[nums.length - k];
        //Monotonically increasing stack.
        //When elements leave, remove them from the beginning

        return solution;
    }
}
