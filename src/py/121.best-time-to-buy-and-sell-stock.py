#
# @lc app=leetcode id=121 lang=python3
#
# [121] Best Time to Buy and Sell Stock
#
# https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
#
# algorithms
# Easy (54.86%)
# Likes:    33022
# Dislikes: 1276
# Total Accepted:    6.3M
# Total Submissions: 11.4M
# Testcase Example:  '[7,1,5,3,6,4]'
#
# You are given an array prices where prices[i] is the price of a given stock
# on the i^th day.
# 
# You want to maximize your profit by choosing a single day to buy one stock
# and choosing a different day in the future to sell that stock.
# 
# Return the maximum profit you can achieve from this transaction. If you
# cannot achieve any profit, return 0.
# 
# 
# Example 1:
# 
# 
# Input: prices = [7,1,5,3,6,4]
# Output: 5
# Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
# 6-1 = 5.
# Note that buying on day 2 and selling on day 1 is not allowed because you
# must buy before you sell.
# 
# 
# Example 2:
# 
# 
# Input: prices = [7,6,4,3,1]
# Output: 0
# Explanation: In this case, no transactions are done and the max profit =
# 0.
# 
# 
# 
# Constraints:
# 
# 
# 1 <= prices.length <= 10^5
# 0 <= prices[i] <= 10^4
# 
# 
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        # store the min
        # iterate, keep comparing, set max_profit
        # if it's less, make it min
        if len(prices) == 0:
            return 0
        max_profit = 0
        current_min = prices[0]

        for i in range(len(prices)):
            if prices[i] < current_min:
                current_min = prices[i]
            else:
                if (prices[i] - current_min) > max_profit:
                    max_profit = prices[i] - current_min
        
        return max_profit
# @lc code=end

