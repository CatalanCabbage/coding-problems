#
# @lc app=leetcode id=1984 lang=python3
#
# [1984] Minimum Difference Between Highest and Lowest of K Scores
#
# https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
#
# algorithms
# Easy (58.14%)
# Likes:    1066
# Dislikes: 318
# Total Accepted:    103.8K
# Total Submissions: 178.4K
# Testcase Example:  '[90]\n1'
#
# You are given a 0-indexed integer array nums, where nums[i] represents the
# score of the i^th student. You are also given an integer k.
# 
# Pick the scores of any k students from the array so that the difference
# between the highest and the lowest of the k scores is minimized.
# 
# Return the minimum possible difference.
# 
# 
# Example 1:
# 
# 
# Input: nums = [90], k = 1
# Output: 0
# Explanation: There is one way to pick score(s) of one student:
# - [90]. The difference between the highest and lowest score is 90 - 90 = 0.
# The minimum possible difference is 0.
# 
# 
# Example 2:
# 
# 
# Input: nums = [9,4,1,7], k = 2
# Output: 2
# Explanation: There are six ways to pick score(s) of two students:
# - [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 =
# 5.
# - [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 =
# 8.
# - [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 =
# 2.
# - [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 =
# 3.
# - [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 =
# 3.
# - [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 =
# 6.
# The minimum possible difference is 2.
# 
# 
# Constraints:
# 
# 
# 1 <= k <= nums.length <= 1000
# 0 <= nums[i] <= 10^5
# 
# 
#

# @lc code=start
class Solution:
    def minimumDifference(self, nums: list[int], k: int) -> int:
        if len(nums) <= 1:
            return 0
        
        min_difference = 1000000
        nums = sorted(nums)
        for i in range(0, len(nums) - k + 1):
            difference = abs(nums[i] - nums[i + k - 1])
            if difference < min_difference:
                min_difference = difference

        return min_difference

        
# @lc code=end

