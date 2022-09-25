/**
 * @author Davis Jeffrey
 */
package patterns.two_heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value and
 * the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 *
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 * Link: https://leetcode.com/problems/find-median-from-data-stream/
 *
 * Times: 2
 * Rating: 4
 */

public class FindMedianFromDataStream {
    //Idea is that maxHeap has first half of inputs, minHeap has second half.
    //Invariant: maxHeap.size() = minHeap.size() || minHeap.size() + 1

    //Note: Size comparison can be replaced with a boolean flag
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size() + 1) {
            maxHeap.offer(num);
            //Put in minHeap because maxHeap is greater
            minHeap.offer(maxHeap.poll());
            //System.out.println(minHeap);
        } else {
            minHeap.offer(num);
            //Put in maxHeap
            maxHeap.offer(minHeap.poll());
            //System.out.println(maxHeap);
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            //Bug: Did /2 instead of /2.0
            return (minHeap.peek() / 2.0) + (maxHeap.peek() / 2.0);
        }
    }
}
