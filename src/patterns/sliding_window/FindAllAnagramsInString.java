package patterns.sliding_window;

import java.util.LinkedList;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 * <p>
 * Eg: Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6] (The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".)
 * <p>
 * Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */

class FindAllAnagramsInString {
    public List<Integer> findAnagrams(String s, String p) {
        //Goal: Find all permutations of p in s.
        int[] map = new int[128];
        List<Integer> solutions = new LinkedList<>();

        //Add all needed chars to map
        for (char c : p.toCharArray()) {
            map[c]++;
        }

        int counter = p.length();
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (map[c1] > 0) {
                counter--;
            }
            map[c1]--;
            right++;
            while (counter == 0) {
                if (right - left == p.length()) {
                    solutions.add(left);
                }
                char c2 = s.charAt(left);
                map[c2]++;
                if (map[c2] > 0) {
                    counter++;
                }
                left++;
            }
        }
        return solutions;
    }
}
