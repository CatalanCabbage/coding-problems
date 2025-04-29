#
# @lc app=leetcode id=20 lang=python3
#
# [20] Valid Parentheses
#
# https://leetcode.com/problems/valid-parentheses/description/
#
# algorithms
# Easy (41.95%)
# Likes:    25596
# Dislikes: 1872
# Total Accepted:    5.9M
# Total Submissions: 14.1M
# Testcase Example:  '"()"'
#
# Given a string s containing just the characters '(', ')', '{', '}', '[' and
# ']', determine if the input string is valid.
# 
# An input string is valid if:
# 
# 
# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
# Every close bracket has a corresponding open bracket of the same type.
# 
# 
# 
# Example 1:
# 
# 
# Input: s = "()"
# 
# Output: true
# 
# 
# Example 2:
# 
# 
# Input: s = "()[]{}"
# 
# Output: true
# 
# 
# Example 3:
# 
# 
# Input: s = "(]"
# 
# Output: false
# 
# 
# Example 4:
# 
# 
# Input: s = "([])"
# 
# Output: true
# 
# 
# 
# Constraints:
# 
# 
# 1 <= s.length <= 10^4
# s consists of parentheses only '()[]{}'.
# 
# 
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        brackets_stack = []
        opposites = {}
        for char in s:
            if char in ["(", "{", "["]:
                brackets_stack.append(char)
            elif char == ")":
                if not brackets_stack or brackets_stack.pop() != "(":
                    return False
            elif char == "}":
                if not brackets_stack or brackets_stack.pop() != "{":
                    return False
            elif char == "]":
                if not brackets_stack or brackets_stack.pop() != "[":
                    return False
        return not brackets_stack
        
# @lc code=end

