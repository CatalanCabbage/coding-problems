/**
 * Problem:
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 *  The left subtree of a node contains only nodes with keys less than the node's key.
 *  The right subtree of a node contains only nodes with keys greater than the node's key.
 *  Both the left and right subtrees must also be binary search trees.
 *
 * Link: https://leetcode.com/problems/validate-binary-search-tree/
 */


class ValidateBinarySearchTree {

    public boolean isValidBST2(TreeNode root) {
        return isValidBST2(root, null, null);
    }

    public boolean isValidBST2(TreeNode root, Integer minVal, Integer maxVal) {
        if (root == null) {
            return true;
        }
        if (maxVal != null && root.val >= maxVal) {
            return false;
        }
        if (minVal != null && root.val <= minVal) {
            return false;
        }

        //These 2 lines aren't needed, but it's easier to understand this way
        minVal = minVal == null ? null : Math.min(minVal, root.val);
        maxVal = maxVal == null ? null : Math.max(maxVal, root.val);

        return isValidBST2(root.left, minVal, root.val) && isValidBST2(root.right, root.val, maxVal);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && getMaxVal(root.left) >= root.val) {
            return false;
        }
        if (root.right != null && getMinVal(root.right) <= root.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    private int getMaxVal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = root.val;
        if (root.left != null) {
            max = Math.max(max, getMaxVal(root.left));
        }
        if (root.right != null) {
            max = Math.max(getMaxVal(root.right), max);
        }
        return max;
    }

    private int getMinVal(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int min = root.val;
        if (root.left != null) {
            min = Math.min(min, getMinVal(root.left));
        }
        if (root.right != null) {
            min = Math.min(getMinVal(root.right), min);
        }
        return min;
    }

    public static void main(String[] args) {
        //[5,1,4,null,null,3,6]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        ValidateBinarySearchTree solve = new ValidateBinarySearchTree();
        solve.isValidBST(root);

        //[32,26,47,19,null,null,56,null,27]
        TreeNode root2 = new TreeNode(32);
        root2.left = new TreeNode(26);
        root2.right = new TreeNode(47);
        root2.left.left = new TreeNode(19);
        root2.right.right = new TreeNode(56);
        root2.left.left.right = new TreeNode(27);
        solve.isValidBST(root2);

        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(14);
        root3.left.left = new TreeNode(1);
        solve.isValidBST(root3);
    }
}
