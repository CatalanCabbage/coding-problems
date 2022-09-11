import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Link: https://leetcode.com/problems/group-anagrams/
 */
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> db = new HashMap<>();
        for (String s : strs) {
            //Get all the chars here
            char[] chars = new char[26];
            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a'] += 1;
            }

            //Construct a kind of hash
            String sorted = String.valueOf(chars);
            List<String> anagrams = db.getOrDefault(sorted, new ArrayList<>());
            anagrams.add(s);
            db.put(sorted, anagrams);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : db.keySet()) {
            result.add(db.get(key));
        }
        return result;
    }
}
