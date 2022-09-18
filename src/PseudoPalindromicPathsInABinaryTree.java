/**
 * @author Davis Jeffrey
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Problem:
 * Given a binary tree where node values are digits from 1 to 9.
 * A path in the binary tree is said to be pseudo-palindromic if
 * at least one permutation of the node values in the path is a palindrome.
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 *
 * Link: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 */
public class PseudoPalindromicPathsInABinaryTree {
    int palindromes = 0;
    public int pseudoPalindromicPaths(TreeNode root) {
        //Do DFS. When path is obtained, check if palindrome can be formed
        //A palindrome can be formed if there are even number of all elements except maybe 1
        checkPaths(root, new HashSet<Integer>());
        return palindromes;
    }

    private void checkPaths(TreeNode root, HashSet<Integer> path) {
        if (root == null) {
            return;
        }
        if (path.contains(root.val)) {
            path.remove(root.val);
        } else {
            path.add(root.val);
        }
        if (root.left != null) {
            checkPaths(root.left, new HashSet<>(path));
        }
        if (root.right != null) {
            checkPaths(root.right, new HashSet<>(path));
        }

        if (root.left == null && root.right == null) {
            //This is a leaf, validate for palindrome
            checkIfPalindrome(path);
        }
    }

    private void checkIfPalindrome(Set<Integer> path) {
        if (path.size() <= 1) {
            palindromes++;
        }
    }
}
