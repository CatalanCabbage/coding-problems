import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Eg: Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Times: 2
 * Rating: 5
 */


class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        if (s == null) {
            return maxLength;
        }

        //Left and right pointers start at 0.
        int left = 0;
        int right = 0;
        Set<Character> charsInWindow = new HashSet<>();
        //Error: Had used left < s.length() - 1 && right < s.length(), but -1 is not needed.
        //Error 2: left < s.length() itself isn't needed
        while (right < s.length()) {
            if (charsInWindow.contains(s.charAt(right))) {
                //If duplicate: Remove charAt(left) and move left pointer
                charsInWindow.remove(s.charAt(left));
                left++;
            } else {
                //If not duplicate: Store char at right pointer and move right
                charsInWindow.add(s.charAt(right));
                //Error: Forgot to do Math.max() :/
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
        }
        return maxLength;
    }
}
