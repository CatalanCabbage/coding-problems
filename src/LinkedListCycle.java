/**
 * Problem:
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * Solution: Floyd's cycle detection algorithm
 * Link: https://leetcode.com/problems/linked-list-cycle/
 */

/**
 * Problem: Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Link: https://leetcode.com/problems/linked-list-cycle/
 *
 * Times: 2
 * Rating: 5
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode pointer1 = head; //Slow
        ListNode pointer2 = head; //Fast
        while (pointer2 != null && pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
            if (pointer1 == pointer2) {
                return true;
            }
        }
        return false;
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
