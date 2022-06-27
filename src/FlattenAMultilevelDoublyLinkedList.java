/**
 * Problem:
 * You are given a doubly linked list, which contains nodes that have a next pointer,
 * a previous pointer, and an additional child pointer.
 * This child pointer may or may not point to a separate doubly linked list, also containing these special nodes.
 * These child lists may have one or more children of their own, and so on,
 * to produce a multilevel data structure as shown in the example below.
 *
 * Given the head of the first level of the list,
 * flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * Let curr be a node with a child list.
 * The nodes in the child list should appear after curr and before curr.next in the flattened list.
 *
 * Return the head of the flattened list.
 * The nodes in the list must have all of their child pointers set to null.
 *
 * Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * Times: 1
 * Rating: 4
 */


class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        return getFlattenedNode(head);
    }

    //Problem now: Each node in child might have more children.
    private Node getFlattenedNode(Node head) {
        if (head == null) return head;
        //Let's say there's only 1 level. What's the solution?

        //System.out.println("Initial [head, child, next] = " + head.val + ", " + (head.child != null ? head.child.val : "-") + ", " + (head.next == null ? "-" : head.next.val));
        //System.out.println("Flattening for " + head.val + ".");
        Node child = getFlattenedNode(head.child);
        Node next = getFlattenedNode(head.next);

        if (child != null) {
            //Append child to head
            head.next = child;
            child.prev = head;
            head.child = null;

            //Append next to end of child
            while (child.next != null) {
                child = child.next;
            }
            child.next = next;
            if (next != null) {
                next.prev = child;
            }
        }
        //System.out.println("Final [head, child, next] = " + head.val + ", " + (head.child != null ? head.child.val : "-") + ", " + (next == null ? "-" : next.val));
        return head;
    }

    private class Node {
        int val;
        Node prev;
        Node next;
        Node child;
    };
}
