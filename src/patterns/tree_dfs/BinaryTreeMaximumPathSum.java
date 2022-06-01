package patterns.tree_dfs;

/**
 * A path in a binary tree is a sequence of nodes where
 * each pair of adjacent nodes in the sequence has an edge connecting them.
 *
 * A node can only appear in the sequence at most once.
 * Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any path.
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 *
 * Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */

class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPath(root);
        return maxSum;
    }

    //Calculate the max of left and right and pass the max up the root
    private int getMaxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //Get sum of left and right paths
        //IMPORTANT: If one path < 0, we can just ignore that path
        int leftSum = Math.max(0, getMaxPath(root.left));
        int rightSum = Math.max(0, getMaxPath(root.right));

        //We need to pass this up to the root
        int currentMaxPath = Math.max(leftSum, rightSum);

        int currentSum = leftSum + rightSum + root.val;
        maxSum = Math.max(currentSum, maxSum);

        return currentMaxPath + root.val;
    }

    //If modifying the tree is fine
    //Post-order traversal. Cleck left, check right, add them up and calculate total path
    private void getMaxPathSum(TreeNode root) {
        if (root.left != null) {
            getMaxPathSum(root.left);
        }
        if (root.right != null) {
            getMaxPathSum(root.right);
        }

        //If any path < 0, ignore it
        int leftVal = root.left == null ? 0 : Math.max(0, root.left.val);
        int rightVal = root.right == null ? 0 : Math.max(0, root.right.val);

        //Sum is left + right + root.val
        maxSum = Math.max(maxSum, (leftVal + rightVal + root.val));

        //Current root's val: root.val + left or right
        root.val = Math.max(leftVal, rightVal) + root.val;
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
