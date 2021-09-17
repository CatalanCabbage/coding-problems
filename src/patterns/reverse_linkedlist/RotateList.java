/**
 * @author Davis Jeffrey
 */
package patterns.reverse_linkedlist;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Eg: Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 *
 * Link: https://leetcode.com/problems/rotate-list/
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode initialFirst = dummy.next;

        int length = 0;
        while (head != null) {
            System.out.println("Head: " + head.val);
            head = head.next;
            length++;
        }

        int rotations = k % length;
        System.out.println("Length: " + length);
        if (rotations == 0) {
            return dummy.next;
        }
        int newHeadIndex = length - rotations;
        System.out.println("HeadIndex: " + newHeadIndex);

        head = dummy.next;
        System.out.println("head: " + head.val);
        //Find (n-1)th node
        for (int i = 0; i < newHeadIndex - 1; i++) {
            //Move to next
            head = head.next;
        }

        System.out.println("Found the divide: " + head.val);
        ListNode newStart = head.next;
        head.next = null;

        head = newStart;
        while (head.next != null) {
            head = head.next;
        }
        head.next = initialFirst;

        return newStart;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
