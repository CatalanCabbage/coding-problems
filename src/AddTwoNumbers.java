/**
 * @author Davis Jeffrey
 */

/**
 * Problem: https://leetcode.com/problems/add-two-numbers/
 * Statement: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * Eg: Input: [2,4,3], [5,6,4] and Output: [7,0,8]
 * Discussions soln ref: https://leetcode.com/problems/add-two-numbers/discuss/1010/Is-this-Algorithm-optimal-or-what/1539
 * <p>
 * Solution:
 * Similar to normal addition - since numbers are reversed, just add - if more than 10, carry 1 over.
 * Keep going till numbers in both lists are done and no remainder is left.
 * Time: O(max(l1.len, l2.len))
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
            int num1 = node1 == null ? 0 : node1.val;
            int num2 = node2 == null ? 0 : node2.val;

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

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


