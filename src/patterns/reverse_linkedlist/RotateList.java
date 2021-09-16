/**
 * @author Davis Jeffrey
 */
package patterns.reverse_linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Eg: Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Link: https://leetcode.com/problems/swap-nodes-in-pairs/
 */

public class RotateList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head;
        ListNode prev = head;
        head = head.next;

        while (head != null) {
            ListNode next = head.next;

            //|  Next pair (next, next.next)  | Previous pair (prev.next) should point to: |
            //| (null, null)| null |
            //| (1, null)   |   1  |
            //| (1, 2)      |   2  |
            prev.next = next == null ? null : next.next == null ? next : next.next;

            head.next = prev;
            if (next == null || next.next == null) {
                break;
            }
            prev = next;
            head = next.next;
        }
        return dummy;
    }

    public static void main(String[] args) {
        swapPairs(
            new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4, null)))));
    }
}
