/**
 * @author Davis Jeffrey
 */

import java.util.PriorityQueue;

/**
 * Problem:
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Link: https://leetcode.com/problems/merge-k-sorted-lists/
 */




public class MergeKSortedLists {
    //O(n * log (k))
    public ListNode mergeKLists(ListNode[] lists) {
        //Add everything to a PQ - n * log(k)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            while(lists[i] != null) {
                minHeap.offer(lists[i].val);
                lists[i] = lists[i].next;
            }
        }
        ListNode result = new ListNode();
        ListNode head = result;
        //Move from PQ to list - n
        while (!minHeap.isEmpty()) {
            head.next = new ListNode(minHeap.poll());
            head = head.next;
        }

        return result.next;
    }


    //Brute force
    //Hold a pointer in each list. In each iteration, add 1 to result.
    //Time complexity = total nodes * lists count
    public ListNode mergeKListsBruteForce(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode head = result;
        int listWithSmallestValue;
        int smallestValue;
        while(areNodesPresent(lists)) {
            //Find smallest value
            listWithSmallestValue = 0;
            smallestValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val <= smallestValue) {
                        smallestValue = lists[i].val;
                        listWithSmallestValue = i;
                    }
                }
            }

            //Add smallest value to result
            head.next = new ListNode(smallestValue);
            head = head.next;
            lists[listWithSmallestValue] = lists[listWithSmallestValue].next;
        }
        return result.next;
    }

    private boolean areNodesPresent(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                //System.out.println("Exist - " + lists[i].val);
                return true;
            }
        }
        return false;
    }
}
