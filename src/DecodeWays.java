/**
 * Problem: A message containing letters from A-Z can be encoded into numbers using the following
 * mapping: 'A' -> "1" 'B' -> "2" ... 'Z' -> "26"
 *
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using
 * the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped
 * into: "AAJF" with the grouping (1 1 10 6) "KJF" with the grouping (11 10 6)
 *
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is
 * different from "06". Given a string s containing only digits, return the number of ways to decode
 * it. The test cases are generated so that the answer fits in a 32-bit integer.
 *
 * Link: https://leetcode.com/problems/decode-ways/
 *
 * Times: 1 Rating: 0
 */

//https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp
class DecodeWays {

    //1. Recursive, TLE
    public int numDecodings(String s) {
        return s.length() == 0 ? 0 : numDecodings(0, s);
    }

    //Get number of ways the string can be interpreted
    private int numDecodings(int currentChar, String s) {
        int len = s.length();
        if (currentChar == len) {
            //Last char, there's no possibility of combination with next char
            return 1;
        }
        if (s.charAt(currentChar) == '0') {
            //Case 1: First char of string is 0. Return 0, since no solution
            //Case 2: 0 comes in the middle. Combination with prev char is already covered in
            //  previous iteration
            return 0;
        }

        //This number is from 1-9. As of now this doesn't contribute to giving us a new path,
        //so just take the next by default.
        //Note: This is not like other problems where each step mandatorily contributes some value (coins, steps etc)
        int res = numDecodings(currentChar + 1, s);

        //Does this form a combination with the next char?
        //If yes, apart from the normal single-digit interpretation, this contributes a different path.
        //Take the ways from that path too.
        if (currentChar < len - 1 && (s.charAt(currentChar) == '1'
            || s.charAt(currentChar) == '2' && s.charAt(currentChar + 1) < '7')) {
            res += numDecodings(currentChar + 2, s);
        }
        return res;
    }


    //2. Recursive with memoization
    public int numDecodingsDp(String s) {
        int[] dp = new int[s.length()];
        return s.length() == 0 ? 0 : numDecodingsDp(0, s, dp);
    }

    //Get number of ways the string can be interpreted
    private int numDecodingsDp(int currentChar, String s, int[] dp) {
        int len = s.length();
        if (currentChar == len) {
            return 1;
        }
        if (s.charAt(currentChar) == '0') {
            return 0;
        }
        if (dp[currentChar] != 0) {
            return dp[currentChar];
        }

        int res = numDecodingsDp(currentChar + 1, s, dp);

        if (currentChar < len - 1 && (s.charAt(currentChar) == '1'
            || s.charAt(currentChar) == '2' && s.charAt(currentChar + 1) < '7')) {
            res += numDecodingsDp(currentChar + 2, s, dp);
        }
        dp[currentChar] = res;
        return res;
    }

    //3. Iterative
    public int numDecodingsIter(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
                if (i < n - 1 && (s.charAt(i) == '1'
                    || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    //4. Iterative with O(n) space
    public int numDecodingsIterSpace(String s) {
        int n = s.length();
        int dp1 = 1;
        int dp2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            int res = 0;
            if (s.charAt(i) != '0') {
                res = dp1;
                if (i < n - 1 && (s.charAt(i) == '1'
                    || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    res += dp2;
                }
            }
            dp2 = dp1;
            dp1 = res;
        }
        return dp1; //Since res is stored in dp1 in the end
    }
}
