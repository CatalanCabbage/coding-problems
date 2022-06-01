/**
 * Problem:
 * Given a string s, return the longest palindromic substring in s.
 *
 * Link: https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Eg. Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 */


class LongestPalindromicSubstring {
    String longestPalindrome = "";
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        } else if (s.length() == 1) {
            return String.valueOf(s.charAt(0));
        }
        return "";
    }

    private void helper(String s) {
        //Case 1: Skip left element
        //Case 2: Skip right element
    }
}
