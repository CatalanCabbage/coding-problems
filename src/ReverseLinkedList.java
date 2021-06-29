/**
 * Problem:
 * Reverse a singly linked list.
 * <p>
 * Link: https://leetcode.com/problems/reverse-linked-list/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode solution;
        solution = solveIteratively(head);
        solution = solveRecursively(head);
        return solution;
    }

    private ListNode solveIteratively(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private ListNode solveRecursively(ListNode head) {
        return solveRecursively(head, null);
    }

    private ListNode solveRecursively(ListNode head, ListNode previous) {
        if (head == null) {
            return previous;
        }
        ListNode next = head.next;
        head.next = previous;
        return solveRecursively(next, head);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
