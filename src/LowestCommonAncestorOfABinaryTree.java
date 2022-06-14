import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Problem: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the
 * tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 * two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a
 * node to be a descendant of itself).”
 *
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */


class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parents.put(root, null);
        stack.push(root);

        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode currentNode = stack.pop();
            if (currentNode.right != null) {
                stack.push(currentNode.right);
                parents.put(currentNode.right, currentNode);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
                parents.put(currentNode.left, currentNode);
            }
        }

        Set<TreeNode> ancestors = new HashSet<TreeNode>();

        while (p != null) {
            ancestors.add(p);
            p = parents.get(p);
        }

        while (q != null) {
            if (ancestors.contains(q)) {
                return q;
            }
            q = parents.get(q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //p or q is found, so this is:
        //Case 1: The LCA
        //Case 2: p or q (and the other is somewhere else) - will be taken care of by recursive stack
        if (root == p || root == q) {
            return root;
        }
        //Does p or q exist in the left subtree?
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //Does p or q exist in the left subtree?
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            //p and q are on either side, so this must be the LCA
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
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
