package patterns.tree_dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 * Eg: Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Link: https://leetcode.com/problems/diameter-of-binary-tree/
 */

class DiameterOfBinaryTree {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //Calculate (left depth) + (right depth) at each node
        //Return the largest
        findLocalDiameter(root);
        return diameter;
    }

    private int findLocalDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = findLocalDiameter(root.left);
        int rightDepth = findLocalDiameter(root.right);

        //To be sent to the root node, will contribute to one branch of the diameter
        int currentLongest = leftDepth > rightDepth ? leftDepth : rightDepth;

        int localDiameter = leftDepth + rightDepth;
        diameter = localDiameter > diameter ? localDiameter : diameter;

        return currentLongest + 1;
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
