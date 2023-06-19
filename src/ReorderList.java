public class ReorderList {
    /**
     * Problem:
     * You are given the head of a singly linked-list. The list can be represented as:
     * L0 → L1 → … → Ln - 1 → Ln
     * Reorder the list to be on the following form:
     * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
     * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
     * <p>
     * Link: https://leetcode.com/problems/reorder-list/
     */

    public void reorderList(ListNode head) {
        //find mid
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse it
        ListNode previous = reverseList(slow.next);
        // breaking the list from the middle
        slow.next = null;

        //merge
        ListNode headRef = head;
        ListNode front = head;
        ListNode back = previous;
        ListNode frontNext = front;
        ListNode backNext = back;
        boolean takeFrontList = false;

        while (front != null && back != null) {
            frontNext = front.next;
            front.next = back;
            backNext = back.next;

            back.next = frontNext;

            front = frontNext;
            back = backNext;
        }

    }

    // method to reverse the linkedList
    public ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
