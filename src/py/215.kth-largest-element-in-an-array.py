#
# @lc app=leetcode id=215 lang=python3
#
# [215] Kth Largest Element in an Array
#
# https://leetcode.com/problems/kth-largest-element-in-an-array/description/
#
# algorithms
# Medium (67.69%)
# Likes:    17855
# Dislikes: 934
# Total Accepted:    3M
# Total Submissions: 4.4M
# Testcase Example:  '[3,2,1,5,6,4]\n2'
#
# Given an integer array nums and an integer k, return the k^th largest element
# in the array.
# 
# Note that it is the k^th largest element in the sorted order, not the k^th
# distinct element.
# 
# Can you solve it without sorting?
# 
# 
# Example 1:
# Input: nums = [3,2,1,5,6,4], k = 2
# Output: 5
# Example 2:
# Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
# Output: 4
# 
# 
# Constraints:
# 
# 
# 1 <= k <= nums.length <= 10^5
# -10^4 <= nums[i] <= 10^4
# 
# 
#

# @lc code=start
class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        import heapq
        max_heap = []
        for i in range(len(nums)):
            heapq.heappush(max_heap, -(nums[i]))        

        while(k > 0):
            if k == 1:
                return -(max_heap[0])
            heapq.heappop(max_heap)
            k -= 1

        return 0
# @lc code=end

