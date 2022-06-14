/**
 * Problem: Given the root of a binary tree, invert the tree, and return its root.
 *
 * Eg: Input: root = [4,2,7,1,3,6,9] Output: [4,7,2,9,6,3,1]
 *
 * Link: https://leetcode.com/problems/invert-binary-tree/
 */


class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        swapChildren(root);
        return root;
    }

    private void swapChildren(TreeNode root) {
        if (root == null) {
            return;
        }
        swapChildren(root.left);
        swapChildren(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
