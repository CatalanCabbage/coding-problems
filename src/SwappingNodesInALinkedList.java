import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning
 * and the kth node from the end (the list is 1-indexed).
 * Link: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 */

class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 1;
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = null;
        //Find mid
        while (fast != null && fast.next != null) {
            //In case slow is in the middle, we'd need mid - 1 later.
            //For this case, track slow's previous here itself
            slowPrev = slow;

            fast = fast.next.next;
            slow = slow.next;
            if (fast != null) {
                length += 2;
            } else {
                length++;
            }
        }
        fast = head;

        //At this point, fast is at the first node and slow at the middle.

        //Indices of nodes to be swapped
        int index1 = k;
        int index2 = length - k + 1;

        //Find the first node (node at index1)
        ListNode fastPrev = null;
        for (int i = 1; i < Math.min(index1, index2); i++) {
            fastPrev = fast;
            fast = fast.next;
        }

        //Find the second node (node at index2), starting from the middle
        for (int i = (length / 2) + 1; i < Math.max(index1, index2); i++) {
            slowPrev = slow;
            slow = slow.next;
        }

        //At this point, fast is at index1, slow is at index2

        //Finally, swap values of fast and slow nodes, simple.
        // int temp = slow.val;
        // slow.val = fast.val;
        // fast.val = temp;
        // return head;

        //But no, Yeshwanth wanted to swap nodes.
        ListNode slowNext = slow.next;
        if (fast != slowPrev) {
            //Link: (fast's prev) -> slow -> (fast's next)
            if (fastPrev != null) {
                fastPrev.next = slow;
            }
            slow.next = fast.next;

            //Link: (slow's prev) -> fast -> (slow's next)
            if (slowPrev != null) {
                slowPrev.next = fast;
            }
            fast.next = slowNext;
        } else {
            //Are the 2 nodes next to each other? ie., (fast's next) == slow?
            //We handle this separately to prevent a cycle:
            //If we do (fast's prev) -> slow -> (fast's next) like the general case, it becomes
            //(fast's prev) -> slow -> slow, since (fast's next) = slow
            if (fastPrev != null) {
                fastPrev.next = slow;
            }
            slow.next = fast;
            fast.next = slowNext;
        }


        if (index1 == 1 || index2 == 1) {
            //The ex-last node is now the head.
            //If index is somewhere in the middle, head is unchanged
            head = slow;
        }

        return head;
    }
}
