package patterns.tree_dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 * Example:
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 *
 * Link: https://leetcode.com/problems/path-sum-iii/
 */

class PathSum3 {
    private Map<Integer, Integer> sums;
    int target = 0;
    int solutionsCount = 0;
    public int PathSum3(TreeNode root, int targetSum) {
        sums = new HashMap<>();
        target = targetSum;
        sums.put(0,1); //To handle the case where a node itself is equal to target
        checkPaths(root, 0);
        return solutionsCount;
    }
    
    private void checkPaths(TreeNode root, int rootSum) {
        if (root == null) {
            return;
        }
        
        //Where each node's val == sum of nodes in its path:
        //Assuming there is a solution, this is the math:
        //currentSum - rootSum = target (where root = arbitary path start, current = path end)
        int currentSum = root.val + rootSum;
        if (sums.containsKey(currentSum - target)) {
            solutionsCount = solutionsCount + sums.get(currentSum - target);
        }
        
        sums.put(currentSum, sums.getOrDefault(currentSum, 0) + 1);
        
        checkPaths(root.left, currentSum);
        checkPaths(root.right, currentSum);
        
        //This sum-checking happens in a bottom-up method; so once it's done, remove it so that
        //there are no duplicates in this flow
        if(sums.get(currentSum) == 1) {
            sums.remove(currentSum);
        } else {
            sums.put(currentSum, sums.get(currentSum) - 1);
        }
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
