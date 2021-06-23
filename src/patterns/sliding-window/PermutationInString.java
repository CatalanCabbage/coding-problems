/**
 * Given two strings s1 and s2, return true if s2 contains the permutation of s1.
 * In other words, one of s1's permutations is the substring of s2.
 * 
 * Eg: Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true (s2 contains one permutation of s1 ("ba")).
 *
 * Link: https://leetcode.com/problems/permutation-in-string/
 */

class PermutationInString {
    public boolean checkInclusion(String s1, String str) {
        if (s1.length() > str.length()) {
            return false;
        }
        Map<Character, Integer> reqChars = new HashMap<>();
        for (char c : s1.toCharArray()) {
            reqChars.put(c, reqChars.getOrDefault(c, 0) + 1);
        }
        int right = -1;
        int left = 0;
        while (right < str.length() - 1) {
            if (right - left + 1 == s1.length()) {                
                //Add left to map
                if (reqChars.containsKey(str.charAt(left))) {
                    reqChars.put(str.charAt(left), reqChars.get(str.charAt(left)) + 1);
                }
                left++;
            }
            right++;
            if (reqChars.containsKey(str.charAt(right))) {
                reqChars.put(str.charAt(right), reqChars.get(str.charAt(right)) - 1);
            }
            boolean isValid = true;
            for (char c : reqChars.keySet()) {
                if (reqChars.get(c) != 0) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                return true;
            }
        }
        return false;
    }
}
