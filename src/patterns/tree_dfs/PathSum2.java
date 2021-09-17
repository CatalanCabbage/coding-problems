package patterns.tree_dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return all root-to-leaf paths where the sum of the node values in the path equals targetSum.
 * Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node.
 * A leaf is a node with no children.
 *
 * Eg: Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 *
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 *
 * Link: https://leetcode.com/problems/path-sum-ii/
 */

class PathSum2 {
    List<List<Integer>> solutionList = new LinkedList<>();
    int targetSum;
    public List<List<Integer>> PathSum2(TreeNode root, int targetSum) {
        int currentSum = 0;
        this.targetSum = targetSum;
        checkPathSum(root, currentSum, new LinkedList<Integer>());
        return solutionList;
    }

    private void checkPathSum(TreeNode node, int currentSum, List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);

        if (node.left == null && node.right == null && (currentSum + node.val == targetSum)) {
            solutionList.add(path);
        }

        checkPathSum(node.left, currentSum + node.val, new LinkedList(path));
        checkPathSum(node.right, currentSum + node.val, new LinkedList(path));
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
