/**
 * Problem:
 * You are given a singly linked list node containing positive integers.
 * Return the same linked list where every node's next points to the node val nodes ahead.
 * If there's no such node, next should point to null.
 * <p>
 * Eg: Input: [2, 1, 4, 1], Output: [2, 4]
 * Explanation: Note that 2's next is 2 node ahead. 4's next is out of bounds, so it's set to null.
 * <p>
 * Link: https://binarysearch.com/problems/Linked-List-Jumps
 */

/**
 * class LLNode {
 * int val;
 * LLNode next;
 * }
 */

class LinkedListJumps {
    public LLNode solve(LLNode node) {
        LLNode pointer1 = node;
        LLNode pointer2 = node;

        //Move pointer2 ahead `val` times
        //Make pointer1 point to the `val`th node
        //Repeat
        while (pointer2 != null) {
            int jumps = pointer2.val;
            //Keep moving ahead till either `val`th node or a null node is reached
            for (int i = 0; i < jumps && pointer2 != null; i++) {
                pointer2 = pointer2.next;
            }
            //Update the value in the same List
            pointer1.next = pointer2;
            pointer1 = pointer1.next;
        }
        return node;
    }

    class LLNode {
        int val;
        LLNode next;
    }
}
