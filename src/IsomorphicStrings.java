import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character,
 * but a character may map to itself.
 *
 * Link:
 */
class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Set<Character> newChars = new HashSet<>();
        Map<Character, Character> charMapping = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //What's the mapping for the current char?
            //If no mapping is present, take the s char
            char currentChar = charMapping.getOrDefault(s.charAt(i), s.charAt(i));
            char requiredChar = t.charAt(i);

            //Does the current char match the required char?
            if (currentChar == requiredChar) {
                //If yes, add to map if not present already
                if (!charMapping.containsKey(s.charAt(i)) && !newChars.contains(requiredChar)) {
                    charMapping.put(s.charAt(i), s.charAt(i));
                    newChars.add(requiredChar);
                } else {
                    if (!charMapping.containsKey(s.charAt(i)) && newChars.contains(requiredChar)) {
                        return false;
                    }
                }
            } else {
                //If no, try to change it. If we can't, return false
                if (!charMapping.containsKey(s.charAt(i)) && !newChars.contains(requiredChar)) {
                    charMapping.put(s.charAt(i), requiredChar);
                    newChars.add(requiredChar);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
