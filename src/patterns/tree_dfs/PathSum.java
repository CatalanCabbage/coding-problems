package patterns.tree_dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 *
 * Eg: Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 *
 * Link: https://leetcode.com/problems/path-sum/
 */

class PathSum {
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return doesPathReachSum(root, targetSum, 0);
    }

    private boolean doesPathReachSum(TreeNode node, int targetSum, int currentSum) {
        if (node == null) {
            return false;
        }
        //Check if this is leaf and the sum is reached
        currentSum += node.val;
        if (node.left == null && node.right == null) {
            return currentSum == targetSum;
        }

        //If left or right paths have a valid sum, return true
        boolean doesPathReachSum = false;
        doesPathReachSum = doesPathReachSum(node.left, targetSum, currentSum) || doesPathReachSum(node.right, targetSum, currentSum);

        return doesPathReachSum;
    }
}
