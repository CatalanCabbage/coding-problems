/**
 * Problem:
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Link: https://leetcode.com/problems/palindrome-linked-list/
 *
 * Times: 1
 * Rating: 2
 */


class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        //Cut to half
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the second half
        ListNode prev = null;
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = prev;

            prev = slow;
            slow = next;
        }
        slow = prev;


        //Iterate
        while (head != null) {
            // System.out.println("Slow:" + slow.val);
            // System.out.println("Head:" + head.val);
            if (slow.val != head.val) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
}
