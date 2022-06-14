/**
 * Problem: Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 * Link: https://leetcode.com/problems/balanced-binary-tree/
 */


class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root, 0);
    }

    private boolean isBalanced(TreeNode root, int depth) {
        if (root == null) {
            return true;
        }


        int leftDepth = getDepth(root.right, depth);
        int rightDepth = getDepth(root.left, depth);
        boolean isCurrentRootBalanced = true;
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isCurrentRootBalanced = false;
        }
        return isCurrentRootBalanced && isBalanced(root.left, depth + 1) && isBalanced(root.right, depth + 1);
    }

    private int getDepth(TreeNode root, int currentDepth) {
        if (root == null) {
            return currentDepth;
        }
        return Math.max(getDepth(root.left, currentDepth + 1), getDepth(root.right, currentDepth + 1));
    }


    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
