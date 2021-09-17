/**
 * @author Davis Jeffrey
 */
package patterns.reverse_linkedlist;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Eg: Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Link: https://leetcode.com/problems/reverse-nodes-in-k-group/
 */

public class ReverseNodesInKGroup {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode reverseNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode leftEdge = dummy;
        ListNode firstNode = head;

        while (areElementsPresent(head, k)) {
            ListNode prev = head;
            head = head.next;
            firstNode = prev;

            for(int i = 1; i < k; i++) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            leftEdge.next = prev;
            firstNode.next = head;
            leftEdge = firstNode;
        }

        return dummy.next;
    }

    private static boolean areElementsPresent(ListNode head, int k) {
        System.out.println("Head is " + head.val);
        for (int i = 0; i < k; i++) {
            if (head == null) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        reverseNodes(
            new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null))))),
                2);
    }
}
