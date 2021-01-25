/**
 * @author Davis Jeffrey
 */

/**
 * Problem: https://leetcode.com/problems/add-two-numbers/
 * Statement: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * Discussions soln ref: https://leetcode.com/problems/lru-cache/discuss/45911/Java-Hashtable-+-Double-linked-list-(with-a-touch-of-pseudo-nodes)/249529
 * 
 * Solution: 
 * Store key-Node mapping in a HashMap. 
 * When a key is accessed, move corresponding Node to the head of a linkedList<Node>.
 * To eject least recently used value - remove tail of LinkedList and remove corresponding key from HashMap.
 */
 
 
class AddTwoNumbers {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int remainder = 0;
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode result = new ListNode(0, null);
        ListNode resultHead = result;
        while (!(remainder == 0 && node1 == null && node2 == null)) {
        //Get both values
            int num1 = node1 == null? 0 : node1.val;
            int num2 = node2 == null? 0 : node2.val;
            
            //Find sum and digit to be carried over
            int sum = num1 + num2 + remainder;
            remainder = sum / 10;
            
            //Save only ones part
            result.next = new ListNode(sum % 10, null);
            result = result.next;
            
            //If next node exists, move to that
            node1 = node1 == null ? node1 : node1.next;
            node2 = node2 == null ? node2 : node2.next;
        }
        return resultHead.next;
    }
}

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
