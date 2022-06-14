/**
 * @author Davis Jeffrey
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem:
 * Given the root of a Binary Search Tree and a target number k,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int target) {
        Set<Integer> set = new HashSet<>();
        return traverseAndCheck(root, target, set);
    }

    private boolean traverseAndCheck(TreeNode root, int target, Set set) {
        if (root == null) {
            return false;
        }
        if (set.contains(target - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        return traverseAndCheck(root.left, target, set) || traverseAndCheck(root.right, target, set);
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
