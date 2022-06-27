import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * You are given an array of words where each word consists of lowercase English letters.
 *
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere
 * in wordA without changing the order of the other characters to make it equal to wordB.
 *
 *
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1,
 * where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on.
 * A single word is trivially a word chain with k == 1.
 *
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 *
 * Link: https://leetcode.com/problems/longest-string-chain/
 *
 * Times: 1
 * Rating: 0
 */


class ShortEncodingOfWords {
    public int longestStrChain(String[] words) {
        int maxLen = 0;
        Map<String, Integer> wordChains = new HashMap<>();
        //Start from the smallest to biggest
        //For each word, see if a substring exists
        //If it exists, update the current val as 1 + (length of smaller chain)
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        for (String word : words) {
            System.out.println(word);
            int currentMax = 0;
            for (int i = 0; i < word.length(); i++) {
                String substring = word.substring(0, i) + word.substring(i + 1, word.length());
                //System.out.println(0 + " to " + i + " : " + word.substring(0, i) + " + " + (i + 1) + " to " + word.length() + " : " + word.substring(i + 1, word.length()));
                currentMax = Math.max(currentMax, wordChains.getOrDefault(substring, 0) + 1);
            }
            wordChains.put(word, currentMax);
            maxLen = Math.max(maxLen, currentMax);
        }
        return maxLen;
    }
}
