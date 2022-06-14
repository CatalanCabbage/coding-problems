import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Given two strings ransomNote and magazine,
 * return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 *
 * Link: https://leetcode.com/problems/ransom-note/
 */


class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> availableChars = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char temp = magazine.charAt(i);
            availableChars.put(temp, availableChars.getOrDefault(temp, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char temp = ransomNote.charAt(i);
            if (!availableChars.containsKey(temp)) {
                return false;
            }
            int charsRemaining = availableChars.get(temp);
            if (charsRemaining == 0) {
                return false;
            }
            availableChars.put(temp, charsRemaining - 1);
        }
        return true;
    }
}
