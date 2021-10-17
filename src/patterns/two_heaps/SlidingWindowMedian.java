/**
 * @author Davis Jeffrey
 */
package patterns.two_heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle values.
 *
 * For example, if arr = [2,3,4], the median is 3.
 * For example, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 *
 * You are given an integer array nums and an integer k.
 * There is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * Return the median array for each window in the original array.
 * Answers within 10-5 of the actual value will be accepted.
 *
 * Link: https://leetcode.com/problems/sliding-window-median/
 */

public class SlidingWindowMedian {
    double[] solution;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public double[] medianSlidingWindow(int[] nums, int k) {
        //nums = 5, k = 5, solution = 1. (length)
        //nums = 5, k = 4, solution = 2.
        //solution = nums - k + 1
        solution = new double[nums.length - k + 1];
        findMedians(nums, k);
        printSolution();
        return solution;
    }

    private void findMedians(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            addElement(nums[i]);

            if (minHeap.size() + maxHeap.size() == k) {
                solution[i - k + 1] = getMedian();
                removeElement(nums[i - k + 1]);
            }
        }
    }

    private void addElement(int num) {
        if (minHeap.size() <= maxHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    private double getMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() / 2.0) + (maxHeap.peek() / 2.0);
        } else {
            return minHeap.peek();
        }
    }

    private void removeElement(int num) {
        if (!minHeap.remove(num)) {
            maxHeap.remove(num);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        slidingWindowMedian.medianSlidingWindow(nums, k);
    }

    private void printSolution() {
        String soln = "";
        for (int i = 0; i < solution.length; i++) {
            soln = soln.concat(", " + solution[i]);
        }
        System.out.println(soln);
    }
}
