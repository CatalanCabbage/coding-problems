import java.util.Arrays;

/**
 * Problem:
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 *     MinStack() initializes the stack object.
 *     void push(int val) pushes the element val onto the stack.
 *     void pop() removes the element on the top of the stack.
 *     int top() gets the top element of the stack.
 *     int getMin() retrieves the minimum element in the stack.
 *
 * You must implement a solution with O(1) time complexity for each function.
 *
 * Link: https://leetcode.com/problems/min-stack/
 */


class MinStack {
    private class Node {
        Node next;
        int val;
        int min;

        Node (int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    Node root = null;

    public MinStack() {
        root = null;
    }

    public void push(int val) {
        if (root == null) {
            root = new Node(val, val, root);
        } else {
            root = new Node(val, Math.min(root.min, val), root);
        }
    }

    public void pop() {
        root = root.next;
    }

    public int top() {
        return root.val;
    }

    public int getMin() {
        return root.min;
    }
}
