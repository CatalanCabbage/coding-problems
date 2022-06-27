import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Link: https://leetcode.com/problems/climbing-stairs/
 *
 * Times: 1
 * Rating: 3
 */


class ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2) return n;
        int dp[] = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
        //return climbStairs(n, new Integer[n + 1]);
    }
    private int climbStairsRecursive(int n, Integer[] dp) {
        //Number of ways to get to nth step: from n-1 and n-2.
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != null) {
            return dp[n];
        }

        dp[n] = climbStairsRecursive(n - 1, dp) + climbStairsRecursive(n - 2, dp);

        return dp[n];
    }
}
