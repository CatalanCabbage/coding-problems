#
# @lc app=leetcode id=124 lang=python3
#
# [124] Binary Tree Maximum Path Sum
#
# https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
#
# algorithms
# Hard (40.98%)
# Likes:    17482
# Dislikes: 768
# Total Accepted:    1.6M
# Total Submissions: 3.8M
# Testcase Example:  '[1,2,3]'
#
# A path in a binary tree is a sequence of nodes where each pair of adjacent
# nodes in the sequence has an edge connecting them. A node can only appear in
# the sequence at most once. Note that the path does not need to pass through
# the root.
# 
# The path sum of a path is the sum of the node's values in the path.
# 
# Given the root of a binary tree, return the maximum path sum of any non-empty
# path.
# 
# 
# Example 1:
# 
# 
# Input: root = [1,2,3]
# Output: 6
# Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 =
# 6.
# 
# 
# Example 2:
# 
# 
# Input: root = [-10,9,20,null,null,15,7]
# Output: 42
# Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7
# = 42.
# 
# 
# 
# Constraints:
# 
# 
# The number of nodes in the tree is in the range [1, 3 * 10^4].
# -1000 <= Node.val <= 1000
# 
# 
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.memo = {}
        self.max_path_sum = -1001
        if not root:
            return 0
        # max path sum is max(left) + max(right)
        # find max of each node, return largest
        
        # do DFS to loop through and get max for each of them
        self.check_max_paths(root)
        return self.max_path_sum
    
    def check_max_paths(self, root: Optional[TreeNode]):
        if not root:
            return
        max_path_for_root = root.val + self.get_max_for_node(root.left) + self.get_max_for_node(root.right)
        self.max_path_sum = max(self.max_path_sum, max_path_for_root)
        self.check_max_paths(root.left)
        self.check_max_paths(root.right)
        

    def get_max_for_node(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        if root in self.memo:
            return self.memo[root]
        result = root.val + max(self.get_max_for_node(root.left), self.get_max_for_node(root.right))
        result = max(0, result)
        self.memo[root] = result
        return result

        
# @lc code=end

