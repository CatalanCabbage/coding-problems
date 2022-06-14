import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Problem: Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given
 * nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 * two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a
 * node to be a descendant of itself).”
 *
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Intuition: If at any point 1 element is to the right and one is to the left, current element is LCA.
 * If not, keep moving left or right.
 */


class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode node1, TreeNode node2) {
        if (node1.val < root.val && node2.val < root.val) {
            //Both are on the left, so LCA is deeper
            root = lowestCommonAncestor2(root.left, node1, node2);
        } else if (node1.val > root.val && node2.val > root.val) {
            //Both are on the left, so LCA is deeper
            root = lowestCommonAncestor2(root.right, node1, node2);
        } else {
            //Both are on different sides, so this is the LCA
            return root;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
        //Find path of P
        Stack<TreeNode> nodesInPath1 = new Stack<>();
        TreeNode tempRoot = root;

        while (tempRoot != null) {

            nodesInPath1.push(tempRoot);
            if (node1.val == tempRoot.val) {
                break;
            } else if (node1.val < tempRoot.val) {
                tempRoot = tempRoot.left;
            } else {
                tempRoot = tempRoot.right;
            }
        }

        //Find path of Q
        Set<TreeNode> nodesInPath2 = new HashSet<>();
        tempRoot = root;

        while (tempRoot != null) {
            nodesInPath2.add(tempRoot);

            if (node2.val == tempRoot.val) {
                break;
            } else if (node2.val < tempRoot.val) {
                tempRoot = tempRoot.left;
            } else {
                tempRoot = tempRoot.right;
            }
        }

        TreeNode lowestAncestor = root;
        //Check root
        while (!nodesInPath1.isEmpty()) {
            TreeNode tempNode = nodesInPath1.pop();
            System.out.println(tempNode.val);
            if (nodesInPath2.contains(tempNode)) {
                lowestAncestor = tempNode;
                break;
            }
        }

        return lowestAncestor;

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
