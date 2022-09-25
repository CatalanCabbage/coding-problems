/**
 * @author Davis Jeffrey
 */

/**
 * Problem:
 * An alphabetical continuous string is a string consisting of consecutive letters in the alphabet.
 * In other words, it is any substring of the string "abcdefghijklmnopqrstuvwxyz".
 *     For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
 *
 * Given a string s consisting of lowercase letters only,
 * return the length of the longest alphabetical continuous substring.
 *
 * Link: https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/
 */
public class LengthOfTheLongestAlphabeticalContinuousSubstring {
    //abc = 3
    //a = 1
    //abccd = 0
    //apq
    public int longestContinuousSubstring(String s) {
        //for each char
        //check if it's the next consecutive. If it's any char, accept it Update max
        //reset consecutive to any char
        int longest = 0;
        int requiredChar = -1; //-1 means any char
        int currentLongest = 0;
        for (char c : s.toCharArray()) {
            if (requiredChar == -1 || c - 'a' == requiredChar) {
                requiredChar = c - 'a' + 1;
                currentLongest++;
                longest = Math.max(currentLongest, longest);
            } else {
                //Reset it. Required char is the next of this char, and currentLong = 1 (this char alone)
                requiredChar = c - 'a' + 1;
                currentLongest = 1;
            }
        }
        return longest;
    }
}
