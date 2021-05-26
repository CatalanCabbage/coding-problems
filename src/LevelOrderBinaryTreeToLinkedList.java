/**
 * Problem: 
 * Given a binary tree root, convert it to a singly linked list using level order traversal.
 * 
 * Link: https://binarysearch.com/problems/Level-Order-Binary-Tree-to-Linked-List
 */



import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */

/**
 * Push current node to queue
 * Pop the queue and push that node's children into the queue 
 * (this will ensure that nodes are ordered by level in the queue)
 * Do this till queue is empty.
 */
class LevelOrderBinaryTreeToLinkedList {
    public LLNode solve(Tree root) {
        List<Tree> nodeList = new ArrayList<>();
        nodeList.add(root);
        return getListFromTree(nodeList);
    }

    private LLNode getListFromTree(List<Tree> nodeList) {
        Tree currentNode = nodeList.remove(0);
        LLNode head = new LLNode();
        LLNode currentHead = head;
        while (currentNode != null) {
            currentHead.next = new LLNode();
            currentHead = currentHead.next;

            currentHead.val = currentNode.val;
            if (currentNode.left != null) {
                nodeList.add(currentNode.left);
            }
            if (currentNode.right != null) {
                nodeList.add(currentNode.right);
            }
            if (nodeList.size() != 0) {
                currentNode = nodeList.remove(0);
            } else {
                currentNode = null;
            }
        }
        return head.next;
    }
}
