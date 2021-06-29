/**
 * @author Davis Jeffrey
 */

/**
 * Problem: https://leetcode.com/problems/consecutive-numbers-sum/
 * Statement: Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?
 * Eg: Input: 5 and Output: 2 (ways: 5 = 5 = 2 + 3) or Input: 9 and Output: 3 (ways: 9 = 9 = 4 + 5 = 2 + 3 + 4)
 * <p>
 * Solution:
 */


class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int n) {
        int ways = 0;
        for (int i = 1; i * (i - 1) / 2 < n; i++) {
            if ((n - i * (i - 1) / 2) % i == 0) {
                ways++;
            }
        }
        return ways;
    }
}
