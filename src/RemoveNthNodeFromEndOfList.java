/**
 * Problem:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */


class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //See how many are there, traverse and merge.
        //Cases:
        //Middle node, change prev.next
        //First node, don't change prev.next

        ListNode dummy = head;
        int length = 0;
        //Get size of list
        while (dummy != null) {
            dummy = dummy.next;
            length++;
        }
        int nodeToSkip = length - n; //0-indexed

        //Edge case: first node is to be removed
        if (nodeToSkip == 0) {
            return head.next;
        }

        ListNode prevNode = head;
        //i = 1 in order to end at our required ekement
        for (int i = 1; i < nodeToSkip; i++) {
            prevNode = prevNode.next;
        }
        // System.out.println("Prev: " + prevNode.val);
        // System.out.println("Prev.next: " + prevNode.next.val);
        prevNode.next = prevNode.next == null ? null : prevNode.next.next;
        return head;
    }
}
