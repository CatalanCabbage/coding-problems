#
# @lc app=leetcode id=228 lang=python3
#
# [228] Summary Ranges
#
# https://leetcode.com/problems/summary-ranges/description/
#
# algorithms
# Easy (52.68%)
# Likes:    4236
# Dislikes: 2303
# Total Accepted:    757.8K
# Total Submissions: 1.4M
# Testcase Example:  '[0,1,2,4,5,7]'
#
# You are given a sorted unique integer array nums.
# 
# A range [a,b] is the set of all integers from a to b (inclusive).
# 
# Return the smallest sorted list of ranges that cover all the numbers in the
# array exactly. That is, each element of nums is covered by exactly one of the
# ranges, and there is no integer x such that x is in one of the ranges but not
# in nums.
# 
# Each range [a,b] in the list should be output as:
# 
# 
# "a->b" if a != b
# "a" if a == b
# 
# 
# 
# Example 1:
# 
# 
# Input: nums = [0,1,2,4,5,7]
# Output: ["0->2","4->5","7"]
# Explanation: The ranges are:
# [0,2] --> "0->2"
# [4,5] --> "4->5"
# [7,7] --> "7"
# 
# 
# Example 2:
# 
# 
# Input: nums = [0,2,3,4,6,8,9]
# Output: ["0","2->4","6","8->9"]
# Explanation: The ranges are:
# [0,0] --> "0"
# [2,4] --> "2->4"
# [6,6] --> "6"
# [8,9] --> "8->9"
# 
# 
# 
# Constraints:
# 
# 
# 0 <= nums.length <= 20
# -2^31 <= nums[i] <= 2^31 - 1
# All the values of nums are unique.
# nums is sorted in ascending order.
# 
# 
#

# @lc code=start
class Solution:
    def summaryRanges(self, nums: list[int]) -> list[str]:
        result = []
        # start from the first entry, store as start_index 
        # if next index is consecutive, index++
        # when not consecutive or arr end is reached, put it in results
        # set start_index to next and continue
        start_index = 0
        for i in range(0, len(nums)):
            if i == len(nums) - 1:
                # put start to current as an entry
                # if start is same as i, put only i
                if start_index == i:
                    result.append(f"{nums[start_index]}")
                else:
                    result.append(f"{nums[start_index]}->{nums[i]}")
                break
            if nums[i + 1] == (nums[i] + 1):
                # it's consecutive
                continue
            else:
                # not consecutive, store in result and set start_index again
                if start_index == i:
                    result.append(f"{nums[start_index]}")
                else:
                    result.append(f"{nums[start_index]}->{nums[i]}")
                start_index = i + 1


        return result
        
# @lc code=end

