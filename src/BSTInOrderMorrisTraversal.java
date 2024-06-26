/**
 * Problem:
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Eg input: [30,20,40,10,25,35,45,9,null,null,26,null,null,null,null]
 */

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class BSTInOrderMorrisTraversal {
    List<Integer> list = new LinkedList<>();

    public List<Integer> inorderTraversalCommented(TreeNode root) {
        if (root == null) {
            return list;
        }

        TreeNode current = root;
        while (current != null) {
            System.out.println("--Current node: " + current.val + "--");
            if (current.left == null) {
                list.add(current.val);
                current = current.right;
                System.out.println("Left was null, so current = current.right: " + (current == null ? "null" : current.val));
            } else {
                TreeNode prev = current.left;
                System.out.println("Left was not null. So prev node is " + (prev == null ? "null" : prev.val));
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                System.out.println("Prev node is now largest of left sub-tree: " + (prev == null ? "null" : prev.val));
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                    System.out.println("prev.right was null, so linked it to current: " + prev.right.val + " and changed current to:" + current.val);
                } else {
                    System.out.println("prev.right == current");
                    list.add(current.val);
                    prev.right = null;
                    current = current.right;
                    System.out.println("Removed prev.right, made current: " + current.val);
                }
            }
        }
        return list;
    }

    //Clean implementation
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }

        TreeNode current = root;
        while (current != null) {
            //If left is null, take current and move right
            if (current.left == null) {
                list.add(current.val);
                current = current.right;
            } else {
                TreeNode prev = current.left;
                //Take the largest node of left sub-tree (which is the rightmost node of the left sub-tree)
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                //If prev.right is null, it means it hasn't been visited yet
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else if (prev.right == current) {
                    //If prev.right points to current, it means we're at the rightmost point.
                    //Remove the link and add the current node
                    list.add(current.val);
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
