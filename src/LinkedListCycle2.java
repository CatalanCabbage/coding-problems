/**
 * Problem: 
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * 
 * Solution: Floyd's cycle detection algorithm
 * https://cs.stackexchange.com/questions/10360/floyds-cycle-detection-algorithm-determining-the-starting-point-of-cycle/
 *
 * Link: https://leetcode.com/problems/linked-list-cycle-ii/
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        ListNode tail = head;
        //At the end of this loop, either pointer1 and pointer2 are at the meeting point,
        //Or there's no loop.
        while (pointer2 != null && pointer2.next != null) {
            pointer1 = pointer1.next;
            tail = pointer2.next;
            pointer2 = pointer2.next.next;
            if (pointer1 == pointer2) {
                break;
            }
        }
        //If one of these are null, it means there's no cycle
        if (pointer2 == null || pointer2.next == null) {
            return null;
        }
        
        //Start pointer1 from the beginning, pointer2 from meeting point.
        //Both will meet at the beginning of the list.
        pointer1 = head;
        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }
}
