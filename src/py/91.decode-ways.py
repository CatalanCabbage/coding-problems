#
# @lc app=leetcode id=91 lang=python3
#
# [91] Decode Ways
#
# https://leetcode.com/problems/decode-ways/description/
#
# algorithms
# Medium (36.19%)
# Likes:    12356
# Dislikes: 4571
# Total Accepted:    1.4M
# Total Submissions: 4M
# Testcase Example:  '"12"'
#
# You have intercepted a secret message encoded as a string of numbers. The
# message is decoded via the following mapping:
# 
# "1" -> 'A'
# "2" -> 'B'
# ...
# "25" -> 'Y'
# "26" -> 'Z'
# 
# However, while decoding the message, you realize that there are many
# different ways you can decode the message because some codes are contained in
# other codes ("2" and "5" vs "25").
# 
# For example, "11106" can be decoded into:
# 
# 
# "AAJF" with the grouping (1, 1, 10, 6)
# "KJF" with the grouping (11, 10, 6)
# The grouping (1, 11, 06) is invalid because "06" is not a valid code (only
# "6" is valid).
# 
# 
# Note: there may be strings that are impossible to decode.
# 
# Given a string s containing only digits, return the number of ways to decode
# it. If the entire string cannot be decoded in any valid way, return 0.
# 
# The test cases are generated so that the answer fits in a 32-bit integer.
# 
# 
# Example 1:
# 
# 
# Input: s = "12"
# 
# Output: 2
# 
# Explanation:
# 
# "12" could be decoded as "AB" (1 2) or "L" (12).
# 
# 
# Example 2:
# 
# 
# Input: s = "226"
# 
# Output: 3
# 
# Explanation:
# 
# "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
# 
# 
# Example 3:
# 
# 
# Input: s = "06"
# 
# Output: 0
# 
# Explanation:
# 
# "06" cannot be mapped to "F" because of the leading zero ("6" is different
# from "06"). In this case, the string is not a valid encoding, so return
# 0.
# 
# 
# 
# Constraints:
# 
# 
# 1 <= s.length <= 100
# s contains only digits and may contain leading zero(s).
# 
# 
#

# @lc code=start
class Solution:
    
    def numDecodings(self, s: str) -> int:
        # num of ways = num of ways taking current int + num of ways taking next int as well
        self.explored_indices = {}
        return self.get_num_of_ways(0, s, 0, "")

    def get_num_of_ways(self, index: int, s: str, current_ways: int, current_path: str) -> int:
        if self.explored_indices.get(index):
            print(f"{index} exists,  {self.explored_indices[index]}")
            return current_ways + self.explored_indices[index]
        if index == len(s):
            # print(f"DINGDING: current_path {current_path}, incrementing ways to {current_ways + 1}")
            return current_ways + 1
        if index > len(s):
            return 0
        

        if s[index] != '0':
            # if index < len(s) - 1:
                # print(f"current_path {current_path}, exploring {s[index + 1]}")
            current_ways = self.get_num_of_ways(index + 1, s, current_ways, str(current_path + "->" + s[index]))
        
        if (index + 1) < len(s):
            if s[index] == '1' or (s[index] == '2' and s[index + 1] in ['0','1','2','3','4','5','6']):
                # if index < len(s) - 2:
                    # print(f"current_path {current_path}, exploring {s[index + 2]}")
                current_ways = self.get_num_of_ways(index + 2, s, current_ways, str(current_path + "->" + s[index] + s[index + 1]))
        
        # print(f"returning {current_ways} for path {current_path}")
        self.explored_indices[index] = current_ways
        return current_ways
        
# @lc code=end

