import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Problem:
 * Given an input string s and a pattern p,
 * implement regular expression matching with support for '.' and '*' where:
 *     '.' Matches any single character.​​​​
 *     '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * Link: https://leetcode.com/problems/regular-expression-matching/
 */


class RegularExpressionMatching {
    //Testcases: ["a", "a.*.*"], ["a", "a*a"]
    //Missed the case where s is done but chars are still remaining in p, but it's a valid regex.
    //Eg: s has been matched, but remaining chars in p are ".*.*"

    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int sIndex, String p, int pIndex) {
        //Full string is matched
        if (sIndex >= s.length() && pIndex >= p.length()) {
            return true;
        }
        //String isn't matched, but nothing left in pattern
        if (pIndex >= p.length()) {
            return false;
        }

        if (sIndex < s.length() && pIndex < p.length() && dp[sIndex][pIndex] != null) {
            return dp[sIndex][pIndex];
        }

        //Cases:
        //Case 1: Can be single char followed by *, like 'a*'
        //Case 2: Can be single char, 'a' or 'a'

        char regexChar = p.charAt(pIndex);
        //Case 1: Is a char followed by a '*'
        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            //We can either skip the current char or take it
            boolean isMatchWhenSkipped = isMatch(s, sIndex, p, pIndex + 2);
            boolean isMatchWhenTaken = false;
            if (sIndex < s.length() && (regexChar == '.' || s.charAt(sIndex) == regexChar)) {
                isMatchWhenTaken = isMatch(s, sIndex + 1, p, pIndex);
            }

            if (sIndex < s.length() && pIndex < p.length()) {
                dp[sIndex][pIndex] = isMatchWhenSkipped || isMatchWhenTaken;
                return dp[sIndex][pIndex];
            } else {
                return isMatchWhenSkipped || isMatchWhenTaken;
            }
        } else {
            //Case 2: Is a single char
            if (sIndex >= s.length()) {
                return false;
            }

            if (regexChar == '.' || s.charAt(sIndex) == regexChar) {
                dp[sIndex][pIndex] = isMatch(s, sIndex + 1, p, pIndex + 1);
                return dp[sIndex][pIndex];
            } else {
                dp[sIndex][pIndex] = false;
                return dp[sIndex][pIndex];
            }
        }
    }

    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();

        System.out.println(rem.isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*"));
    }

    @Test
    @DisplayName("Testcase 1")
    void isValid1() {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        Assertions.assertTrue(rem.isMatch("aabcbcbcaccbca", ".*a*aa*.*b*.c*.*"));
    }

    @Test
    @DisplayName("Testcase 2")
    void isValid2() {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        Assertions.assertTrue(rem.isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*"));
    }
}
