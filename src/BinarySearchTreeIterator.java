/**
 * Problem:
 * Implement a binary search tree iterator with the following methods:
 * next() - returns the next smallest element in the tree
 * hasnext() - returns whether there is a next element in the iterator
 * <p>
 * Link: https://binarysearch.com/problems/Binary-Search-Tree-Iterator
 */

import java.util.LinkedList;
import java.util.List;

// Implement the BSTIterator class that represents an iterator over
// the in-order traversal of a binary search tree (BST):
//
// BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
// The root of the BST is given as part of the constructor.
// The pointer should be initialized to a non-existent number smaller than any element in the BST.
//
// boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer,
// otherwise returns false.
//
// int next() Moves the pointer to the right, then returns the number at the pointer.
//
// Notice that by initializing the pointer to a non-existent smallest number,
// the first call to next() will return the smallest element in the BST.
//
// You may assume that next() calls will always be valid.
// That is, there will be at least a next number in the in-order traversal when next() is called.

class BinarySearchTreeIterator {
    private LinkedList<Integer> list = new LinkedList<>();

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

    public class Tree {
        int val;
        Tree left;
        Tree right;
    }
}
