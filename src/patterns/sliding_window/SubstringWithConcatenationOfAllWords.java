/**
 * @author Davis Jeffrey
 */
package patterns.sliding_window;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * You are given a string s and an array of strings words of the same length.
 * Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once,
 * in any order, and without any intervening characters.
 * You can return the answer in any order.
 * <p>
 * Eg: Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9] //Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * <p>
 * Link: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

//Similar to other sliding window problems - instead of checking letters, check words.
public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> solution = new LinkedList<>();
        int wordLen = words[0].length();
        int wordsCount = words.length;

        //Put all words needed in a Map
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        int left = 0;

        while (left <= s.length() - wordsCount * wordLen) {
            Map<String, Integer> currentWordsMap = new HashMap<>();
            int counter = words.length;
            int tempLeft = left;
            //Do this till a solution has been reached, or a solution is not possible when starting from this left
            while (counter > 0) {
                String currentWord = s.substring(tempLeft, tempLeft + wordLen);
                if (wordsMap.containsKey(currentWord)) {
                    //This is a word we need!
                    currentWordsMap.put(currentWord, currentWordsMap.getOrDefault(currentWord, 0) + 1);
                    if (currentWordsMap.get(currentWord) > wordsMap.get(currentWord)) {
                        //Word is repeated more times than needed; no possible solution.
                        break;
                    } else {
                        //This contributes to the solution; one less word to find now.
                        counter--;
                    }
                } else {
                    //We don't need this word; no possible solution.
                    break;
                }
                if (counter == 0) {
                    solution.add(left);
                    break;
                }
                //Next word starts from current point + length of current word
                tempLeft = tempLeft + wordLen;
            }
            left++;
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println("Result1 " + findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println("Expected: [0,9]");
        System.out.println("Result2 " + findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
        System.out.println("Expected: []");
        System.out.println("Result3 " + findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
        System.out.println("Expected: [6,9,12]");

    }

}
