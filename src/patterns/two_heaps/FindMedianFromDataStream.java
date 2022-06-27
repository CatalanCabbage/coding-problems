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
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    private boolean isEven = true;

    private FindMedianFromDataStream() {
        //Contains second half of list
        minHeap = new PriorityQueue<>();
        //Contains first half of list
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : o1 == o2 ? 0 : -1;
            }
        });
    }

    //Second poll() is done to maintain the invariant (maxHeap < mid < minHeap)
    private void addNum(int num) {
        if (isEven) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
        isEven = !isEven;
    }

    private double findMedian() {
        if (isEven) {
            //Do /2 separately to prevent overflow
            return (minHeap.peek() / 2.0) + (maxHeap.peek() / 2.0);
        } else {
            return minHeap.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianFromDataStream fm = new FindMedianFromDataStream();
        fm.addNum(1);
        fm.addNum(2);
        System.out.println(fm.findMedian());
        fm.addNum(3);
        System.out.println(fm.findMedian());
    }
}
