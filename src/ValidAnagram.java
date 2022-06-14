/**
 * Problem:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Link: https://leetcode.com/problems/valid-anagram/
 */


class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charOccurances = new int[26];
        int distinctChars = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charOccurances[s.charAt(i) - 'a'] == 0) {
                distinctChars++;
            }
            charOccurances[s.charAt(i) - 'a'] = charOccurances[s.charAt(i) - 'a'] + 1;
        }

        for (int i = 0; i < t.length(); i++) {
            charOccurances[t.charAt(i) - 'a'] = charOccurances[t.charAt(i) - 'a'] - 1;
            if (charOccurances[t.charAt(i) - 'a'] == 0) {
                distinctChars--;
            } else if (charOccurances[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return distinctChars == 0;
    }
}
