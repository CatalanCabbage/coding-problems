/**
 * Problem: 
 * Implement a binary search tree iterator with the following methods:
 * next() - returns the next smallest element in the tree
 * hasnext() - returns whether there is a next element in the iterator
 *
 * Link: https://binarysearch.com/problems/Binary-Search-Tree-Iterator
 */

import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class BinarySearchTreeIterator {
    public BinarySearchTreeIterator(Tree root) {
        populateList(root);
    }

    public int next() {
        //return val and go to next node
        return list.remove();
    }

    public boolean hasnext() {
        //Check if next node isn't null
        return (list.peek() != null);
    }

    private LinkedList<Integer> list = new LinkedList<>();
    private void populateList(Tree node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            populateList(node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            populateList(node.right);
        }
        
    }
}
