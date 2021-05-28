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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode headRef = head;
        int currentNode = 1;
        ListNode prev = null;
        while (currentNode < left) {
            prev = head;
            head = head.next;
            currentNode++;
        }
        //At this point, head == left
        //prev is the left edge
        ListNode leftEdge = prev;

        //Move prev to the first node to be reversed
        prev = head;
        head = head.next;
        currentNode++;

        //prev is the first node now
        ListNode rightRevEdge = prev;

        //Reverse till right edge is reached. In the end, head is rightEdge.
        while (currentNode <= right) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            currentNode++;
        }

        //When `left == 1` - `left` is the first element, there is no unchanged left list.
        //So `prev` is the head, similar to a normal reversed linked list
        if(leftEdge != null) {
            leftEdge.next = prev;
        } else {
            headRef = prev;
        }
        rightRevEdge.next = head;        
        return headRef;
    }
}
