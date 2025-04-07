#
# @lc app=leetcode id=941 lang=python3
#
# [941] Valid Mountain Array
#
# https://leetcode.com/problems/valid-mountain-array/description/
#
# algorithms
# Easy (33.84%)
# Likes:    3015
# Dislikes: 192
# Total Accepted:    479.8K
# Total Submissions: 1.4M
# Testcase Example:  '[2,1]'
#
# Given an array of integers arr, return true if and only if it is a valid
# mountain array.
# 
# Recall that arr is a mountain array if and only if:
# 
# 
# arr.length >= 3
# There exists some i with 0 < i < arr.length - 1 such that:
# 
# arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
# arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
# 
# 
# 
# 
# 
# Example 1:
# Input: arr = [2,1]
# Output: false
# Example 2:
# Input: arr = [3,5,5]
# Output: false
# Example 3:
# Input: arr = [0,3,2,1]
# Output: true
# 
# 
# Constraints:
# 
# 
# 1 <= arr.length <= 10^4
# 0 <= arr[i] <= 10^4
# 
# 
#

# @lc code=start
class Solution:
    def validMountainArray(self, arr: list[int]) -> bool:
        i = 1

        # keep going as long as it ascends
        while (i < len(arr) and arr[i] > arr[i - 1]):
            i += 1

        # if index is 1 or last, not a mountain
        if i == 1 or i == len(arr):
            return False

        # keep going as long as it descends
        while (i < len(arr) and arr[i] < arr[i - 1]):
            i += 1

        # have we reached the end?
        return i == len(arr)


    def validMountainArray2(self, arr: list[int]) -> bool:
        # should have at least 3 vals
        if len(arr) < 3:
            return False
        
        # at least first 2 should be increasing
        if arr[1] <= arr[0]:
            return False
        
        # at least last 2 should be decreasing
        if arr[len(arr) - 1] >= arr[len(arr) - 2]:
            return False
        
        # increasing sequence followed by decreasing sequence
        should_increase = True
        current_val = -1

        for val in arr:
            if should_increase:
                if val < current_val:
                    should_increase = False
                    current_val = val
                elif val == current_val:
                    return False
                else: 
                    current_val = val
            else:
                if val >= current_val:
                    return False
                else:
                    current_val = val
        
        return True
        

# @lc code=end

