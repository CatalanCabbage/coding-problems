/**
 * Problem: 
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * 
 * Solution: Floyd's cycle detection algorithm
 * Link: https://leetcode.com/problems/linked-list-cycle/
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
public class Solution {
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
}
