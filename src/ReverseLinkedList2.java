/**
 * Problem: 
 * Given the head of a singly linked list and two integers left and right where left <= right, 
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * 
 * Link: https://leetcode.com/problems/reverse-linked-list-ii/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * Move normally till Left edge
 * Start reversing
 * Join the last to right edge
 * Edge case: left == 1
 */
class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }
        
        //Always use a dummy to return in the end. 
        //Saves you a lot of pain and null handling
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        ListNode leftEdge = prev;

        //Move prev to the first node to be reversed
        prev = prev.next;
        head = prev.next;

        //prev is the first node now
        ListNode rightRevEdge = prev;

        //Reverse till right edge is reached. In the end, head is rightEdge.
        for (int i = 0; i < right - left; i++) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        leftEdge.next = prev;
        rightRevEdge.next = head;
        
        return dummy.next;
    }
}
